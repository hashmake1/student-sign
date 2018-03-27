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
import com.stu.sign.utils.EqualUtils;

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

	/**
	 * 登陆功能
	 */
	@PostMapping("/loginPost")
	public @ResponseBody Map<String, Object> loginPost(String account, String password, String loginType, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isLoginSuccess = userLoginService.checkAccountAndPwd(account, password, loginType);
		if (isLoginSuccess) {//如果成功,则保存到
			session.setAttribute("ACCOUNT_ID", account);
			session.setAttribute("LOGIN_TYPE", loginType);
			map.put("success", true);
			map.put("message", "登录成功");
		} else {
			map.put("success", false);
			if(EqualUtils.equals(loginType, 1)){
				map.put("message", "教师工号或密码错误");
			}else{
				map.put("message", "学生学号或密码错误");
			}
		}
		return map;
	}

	/**
	 * 登出功能
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 移除session
		session.removeAttribute("ACCOUNT_ID");
		session.removeAttribute("LOGIN_TYPE");
		return "redirect:/login";
	}
}
