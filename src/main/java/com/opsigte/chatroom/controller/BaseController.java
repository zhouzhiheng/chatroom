package com.opsigte.chatroom.controller;

import com.opsigte.chatroom.entity.CUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String page(HttpServletRequest request, @PathVariable(value = "url") String url){
        String room = "room";
        if (room.equals(url)) {
            CUser cUser = (CUser) request.getSession().getAttribute("loginUser");
            if (cUser == null) {
                return "redirect:/";
            }
        }
        return url;
    }

}
