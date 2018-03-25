package com.stu.sign.controller.page;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stu.sign.service.UserLoginService;

@Controller
public class LoginPageController {

	@Autowired
	private UserLoginService userLoginService;

	@RequestMapping("/")
	public String sayHello() {
		return "h5/login";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		return "h5/login";
	}

	@PostMapping("/loginPost")
	public @ResponseBody Map<String, Object> loginPost(String account, String password, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		// if (!"a".equals(password)) {
		// map.put("success", false);
		// map.put("message", "密码错误");
		// return map;
		// }
		boolean isLoginSuccess = userLoginService.checkAccountAndPwd(account, password);
		if (isLoginSuccess) {
			session.setAttribute("SESSION_KEY", account);
			map.put("success", true);
			map.put("message", "登录成功");
		} else {
			session.setAttribute("SESSION_KEY", account);
			map.put("success", false);
			map.put("message", "登录失败");
		}
		return map;
	}

	@RequestMapping("/app")
	public String redirectAppPage() {
		return "h5/app";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 移除session
		session.removeAttribute("SESSION_KEY");
		return "redirect:/login";
	}
}
