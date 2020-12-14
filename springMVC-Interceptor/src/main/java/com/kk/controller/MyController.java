package com.kk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginSuc")
    public String loginSuc(Model model, HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        model.addAttribute("name",userName);
        model.addAttribute("pwd",passWord);
        return "suc";
    }

    @RequestMapping("/regist")
    public String regist(){
        return "register";
    }
}
