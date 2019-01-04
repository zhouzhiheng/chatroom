package com.opsigte.chatroom.service;

import com.opsigte.chatroom.entity.CUser;
import com.opsigte.chatroom.exception.BizException;
import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.vo.UserLoginVO;

import java.util.List;

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


    /**
     * 根据条件查询用户
     *
     * @Title selectBy
     * @param username, password, status
     * @return java.util.List<com.opsigte.chatroom.entity.CUser>
     * @throws CUserException
     */
    List<CUser> selectBy(String username, String password, Integer status) throws CUserException;


    /**
     * 根据主键查询用户
     *
     * @Title selectByPrimary
     * @param uid
     * @return com.opsigte.chatroom.entity.CUser
     * @throws CUserException
     */
    CUser selectByPrimary(String uid) throws CUserException;
}
