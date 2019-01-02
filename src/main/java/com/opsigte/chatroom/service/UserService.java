package com.opsigte.chatroom.service;

import com.opsigte.chatroom.exception.BizException;
import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.vo.UserLoginVO;

/**
 * @Project: com.opsigte.chatroom.service
 * @Class: UserService
 * @Description: 用户service
 * @Author: opsigte
 * @Date: 2019/1/2 11:08
 * @version
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param username, password
     * @return com.opsigte.chatroom.vo.UserLoginVO
     * @throws BizException
     * @Title userLogin
     */
    UserLoginVO login(String username, String password) throws CUserException;

    /**
     * 注册用户
     *
     * @Title addUser
     * @param username, password
     * @return java.lang.String
     * @throws CUserException
     */
    String addUser(String username,String password) throws CUserException;
}
