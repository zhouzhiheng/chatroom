package com.opsigte.chatroom.controller;

import com.opsigte.chatroom.pojo.Resp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@EnableAutoConfiguration
@RequestMapping("chatroom")
public class BizController {

    @RequestMapping(value = "login.json")
    public Resp login(@RequestParam String username,@RequestParam String password){

        System.out.println("username:" + username + " " + "password:" + password);

        return Resp.success();
    }


}
