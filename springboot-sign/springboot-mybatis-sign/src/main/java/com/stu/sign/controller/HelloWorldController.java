package com.stu.sign.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello(Map<String,Object> map) {
    	map.put("hello","欢迎你");
        return"/hello";
    }
    
    @RequestMapping("/hello")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","欢迎");
        map.put("name","大家");
        return"/hello";
    }
}