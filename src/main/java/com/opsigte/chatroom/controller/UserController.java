package com.opsigte.chatroom.controller;

import com.opsigte.chatroom.common.Resp;
import com.opsigte.chatroom.enums.ErrorCode;
import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.service.UserService;
import com.opsigte.chatroom.vo.UserLoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Project: com.opsigte.chatroom.controller
 * @Class: BizController
 * @Description: 业务类
 * @Author: opsigte
 * @Date: 2019/1/2 10:15
 * @version
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("chatroom")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @Title login
     * @param username, password
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @RequestMapping(value = "login.json")
    public Resp login(@RequestParam String username,@RequestParam String password){
        log.info("login入参：username:{},password:{}",username,password);

        try {
            UserLoginVO login = userService.login(username, password);
            return Resp.success(login);
        } catch (CUserException ue) {
            return checkException(ue);
        } catch (Exception e) {
            e.printStackTrace();
            return Resp.fail();
        }
    }


    @RequestMapping(value = "register.json")
    public Resp addUser(@RequestParam String username,@RequestParam String password){
        log.info("addUser入参：username:{},password:{}",username,password);
        try {
            return Resp.success(userService.addUser(username, password));
        } catch (CUserException ce) {
            return checkException(ce);
        } catch (Exception e) {
            return Resp.fail();
        }
    }


    private Resp checkException(CUserException ce){
        int code = ce.getCode();
        switch (code) {
            case CUserException.ACCOUNT_NOT_EXIST:
                return Resp.fail(ErrorCode.ACCOUNT_NOT_EXIST);
            case CUserException.PASSWORD_NOT_MATCH:
                return Resp.fail(ErrorCode.ACCOUNT_PASSWORD_NOT_MATCH);
            case CUserException.ACCOUNT_LOCKED:
                return Resp.fail(ErrorCode.ACCOUNT_LOCKED);
            case CUserException.ACCOUNT_TOO_MANY:
                return Resp.fail(ErrorCode.ACCOUNT_NOT_VALID);
            case CUserException.INPUT_PARAM_IS_NULL:
                return Resp.fail(ErrorCode.PARAM_ERROR);
            case CUserException.ACCOUNT_ALREADY_EXIST:
                return Resp.fail(ErrorCode.ACCOUNT_ALREADY_EXIST);
            default:
                return Resp.fail();
        }
    }


}