package com.kk.controller;

import com.kk.pojo.User;
import com.kk.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class AjaxController {


    @RequestMapping("toajax")
    public String toAjax(){
        return "ajaxTest";
    }


    @RequestMapping("/ajax")
    public void ajaxDemo(String name, HttpServletResponse response) throws IOException {
        if ("admin".equals(name)){
            response.getWriter().println("I Love You!");
        }else response.getWriter().println("FALSE");
    }


    @RequestMapping("/ajax1")
    @ResponseBody   //会返回一个字符串
    public String ajaxDemo1(String name, HttpServletResponse response) throws IOException {
        ArrayList list = new ArrayList();

        list.add(new User(1, "柯神1号", "男"));
        list.add(new User(2,"柯神2号","男"));
        list.add(new User(3,"柯神3号","女"));
        list.add(new User(4,"柯神4号","男"));

        return JsonUtil.getJson(list);
    }





}
