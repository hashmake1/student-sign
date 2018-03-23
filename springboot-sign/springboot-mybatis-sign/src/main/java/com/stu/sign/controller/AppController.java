package com.stu.sign.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/redirectPage")
	public String redirectAppPage(HttpServletRequest request) {
		String pagename = request.getParameter("pagename");
		return "h5/" + pagename.replace(".html", "");
	}
}
