package com.opsigte.chatroom.controller;

import com.opsigte.chatroom.annotation.Authentication;
import com.opsigte.chatroom.common.Resp;
import com.opsigte.chatroom.entity.CUser;
import com.opsigte.chatroom.enums.ErrorCode;
import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.service.ChatMessageService;
import com.opsigte.chatroom.service.UserRelationService;
import com.opsigte.chatroom.service.UserService;
import com.opsigte.chatroom.vo.ChatMessageParam;
import com.opsigte.chatroom.vo.UserRelationInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


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
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;
    @Autowired
    private UserRelationService userRelationService;
    @Autowired
    private ChatMessageService chatMessageService;

    /**
     * 用户登录
     *
     * @Title login
     * @param username, password
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @RequestMapping(value = "login.json")
    public Resp login(HttpServletRequest request, @RequestParam String username, @RequestParam String password){
        log.info("用户登录-入参：username:{},password:{}",username,password);

        try {
            CUser user = userService.login(username, password);
            if (user != null) {
                request.getSession().setAttribute("loginUser", user);
            }
            return Resp.success(user);
        } catch (CUserException ue) {
            return checkException(ue);
        } catch (Exception e) {
            e.printStackTrace();
            return Resp.fail();
        }
    }



    /**
     * 注册用户
     *
     * @Title addUser
     * @param username, password
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @RequestMapping(value = "register.json")
    public Resp addUser(@RequestParam String username,@RequestParam String password){
        log.info("注册用户-入参：username:{},password:{}",username,password);
        try {
            return Resp.success(userService.addUser(username, password));
        } catch (CUserException ce) {
            return checkException(ce);
        } catch (Exception e) {
            return Resp.fail();
        }
    }



    /**
     * 添加好友
     *
     * @Title addRelation
     * @param sourceUid, targetUid
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @RequestMapping(value = "addRelation.json")
    public Resp addRelation(@RequestParam String sourceUid,@RequestParam String targetUid){
        log.info("添加好友-入参:sourceUid:{},targetUid:{}",sourceUid,targetUid);
        try {
            return Resp.success(userRelationService.addRelation(sourceUid, targetUid));
        } catch (CUserException ce) {
            return checkException(ce);
        } catch (Exception e) {
            return Resp.fail();
        }
    }


    /**
     * 根据条件查询用户
     *
     * @Title queryUserBy
     * @param username
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @RequestMapping(value = "queryUserBy.json")
    public Resp queryUserBy(String username){
        log.info("查询用户-入参:username:{}", username);
        try {
            return Resp.success(userService.selectBy(username, null, 1));
        } catch (CUserException ce) {
            return checkException(ce);
        } catch (Exception e) {
            return Resp.fail();
        }
    }



    /**
     * 根据uid查询用户信息
     *
     * @Title queryUserByPrimary
     * @param uid
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @RequestMapping(value = "queryUserByPrimary.json")
    public Resp queryUserByPrimary(@RequestParam String uid){
        log.info("根据uid查询用户信息-入参:uid:{}",uid);
        try {
            return Resp.success(userService.selectByPrimary(uid));
        } catch (CUserException ce) {
            return checkException(ce);
        } catch (Exception e) {
            return Resp.fail();
        }

    }


    /**
     * 根据uid查询好友列表
     *
     * @Title queryRelationList
     * @param uid
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @Authentication
    @RequestMapping(value = "queryRelationList.json")
    public Resp queryRelationList(@RequestParam String uid) {
        log.info("查询好友列表-入参:uid:{}", uid);

        try {
            return Resp.success(userRelationService.selectListByUid(uid));
        } catch (CUserException ce) {
            return checkException(ce);
        } catch (Exception e) {
            return Resp.fail();
        }
    }


    /**
     * 添加消息
     *
     * @Title addMessage
     * @param chatMessageParam
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @Authentication
    @RequestMapping(value = "addMessage.json")
    public Resp addMessage(ChatMessageParam chatMessageParam) {
        log.info("添加消息入参:chatMessageParam:{}", chatMessageParam);

        try {
            return Resp.success(chatMessageService.addMessage(chatMessageParam));
        } catch (CUserException ce) {
            return checkException(ce);
        } catch (Exception e) {
            return Resp.fail();
        }
    }



    /**
     * 查询消息
     *
     * @Title addMessage
     * @param relationId
     * @return com.opsigte.chatroom.common.Resp
     * @throws
     */
    @Authentication
    @RequestMapping(value = "findMessage.json")
    public Resp findMessage(String relationId) {
        log.info("查询消息入参:relationId:{}", relationId);

        try {
            return Resp.success(chatMessageService.findByRelationId(relationId));
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
            case CUserException.RALATION_NOT_MYSELFT:
                return Resp.fail(ErrorCode.RALATION_NOT_MYSELFT);
            case CUserException.DATA_REQUEST_SUCCESS_BUT_IS_NULL:
                return Resp.fail(ErrorCode.DATA_IS_NULL);
            default:
                return Resp.fail();
        }
    }


}
