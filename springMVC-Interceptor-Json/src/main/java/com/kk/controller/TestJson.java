package com.kk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kk.pojo.User;
import com.kk.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class TestJson {


    @RequestMapping("/json")
    @ResponseBody
    public String json() throws JsonProcessingException {

        User user = new User(1, "柯神_", "男");
        return new ObjectMapper().writeValueAsString(user);
    }

    @RequestMapping("/json1")
    @ResponseBody
    public String json1() throws JsonProcessingException {

        ArrayList<User> list = new ArrayList<>();

        User user1 = new User(1, "柯神_", "男");
        User user2 = new User(2, "柯神_", "男");
        User user3 = new User(3, "柯神_", "男");
        User user4 = new User(4, "柯神_", "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return JsonUtil.getJson(list);
    }



    @RequestMapping("/time1")
    @ResponseBody
    public String jsonT1() throws JsonProcessingException {
        return JsonUtil.getJson(new Date());
    }


    @RequestMapping("/time2")
    @ResponseBody
    public String jsonT2() throws JsonProcessingException {
        return JsonUtil.getJson(new Date(),"yyyy-MM-dd HH:mm:ss");
    }



}
