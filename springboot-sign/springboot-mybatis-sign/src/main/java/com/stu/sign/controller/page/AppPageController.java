package com.stu.sign.controller.page;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppPageController {

	/**
	 * 页面跳转
	 */
	@RequestMapping("/redirectPage")
	public String redirectAppPage(HttpServletRequest request) {
		String pagename = request.getParameter("pagename");
		return "h5/" + pagename.replace(".html", "");
	}
	
	@RequestMapping("/app")
	public String redirectAppPage() {
		return "h5/app";
	}
}
