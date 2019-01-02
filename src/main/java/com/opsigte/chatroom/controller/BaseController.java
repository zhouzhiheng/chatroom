package com.opsigte.chatroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project: com.opsigte.chatroom.controller
 * @Class: BaseController
 * @Description: 页面跳转Controller
 * @Author: opsigte
 * @Date: 2018/12/29 11:06
 * @version
 */
@Controller
public class BaseController {


    @RequestMapping(value = {"", "login"})
    public String hello(Model model){
        return "login";
    }

    @RequestMapping(value = "/{url}")
    public String page(@PathVariable(value = "url") String url){
        return url;
    }

}
