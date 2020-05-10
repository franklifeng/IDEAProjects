package com.springboot.cache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author frank
 * @create 2019-08-19 10:51
 */
@Controller
public class TestHello {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello=============");
        return "hello world";
    }
}
