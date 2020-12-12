package com.kk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/regist")
    public String regist(){
        return "register";
    }
}
