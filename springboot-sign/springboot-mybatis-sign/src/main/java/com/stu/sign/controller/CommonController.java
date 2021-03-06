package com.stu.sign.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/getIpAddress")
	public String login(Model model) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
//		String hostAddress = address.getHostAddress();// 192.168.0.121
//		InetAddress address1 = InetAddress.getByName("www.wodexiangce.cn");// 获取的是该网站的ip地址，比如我们所有的请求都通过nginx的，所以这里获取到的其实是nginx服务器的IP地
//		String hostAddress1 = address1.getHostAddress();// 124.237.121.122
//		InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");// 根据主机名返回其可能的所有InetAddress对象
//		for (InetAddress addr : addresses) {
//			System.out.println(addr);// www.baidu.com/14.215.177.38
//
//		}
		return address.getHostAddress();
	}
}
