package com.opsigte.chatroom.service.impl;

import com.opsigte.chatroom.biz.UserBiz;
import com.opsigte.chatroom.entity.CUser;
import com.opsigte.chatroom.exception.BizException;
import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.service.UserService;
import com.opsigte.chatroom.vo.UserRelationInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @Project: com.opsigte.chatroom.service.impl
 * @Class: BizServiceImpl
 * @Description: 用户service实现类
 * @Author: opsigte
 * @Date: 2019/1/2 11:02
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserBiz userBiz;

    /**
     * 用户登录
     *
     * @param username, password
     * @return com.opsigte.chatroom.vo.UserRelationInfoVO
     * @throws BizException
     * @Title userLogin
     */
    @Override
    public CUser login(String username, String password) throws CUserException {

        if (StringUtils.isEmpty(username.trim()) || StringUtils.isEmpty(password)) {
            throw new CUserException(CUserException.INPUT_PARAM_IS_NULL, "参数错误");
        }

        CUser result = new CUser();

        // 查询用户信息
        List<CUser> cUsers = null;
        try {
            cUsers = userBiz.selectBy(username.trim(), null, null);
        } catch (CUserException e) {
            throw new CUserException(BizException.DB_SELECT_ERROR.getCode(), e.getMsg());
        }

        if (cUsers == null || cUsers.size() <= 0) {
            log.info("没有查询到用户，username:{}", username.trim());
            throw new CUserException(CUserException.ACCOUNT_NOT_EXIST, "没有此用户");
        }

        if (cUsers.size() > 1) {
            log.info("存在多个用户，username:{}", username.trim());
            throw new CUserException(CUserException.ACCOUNT_TOO_MANY, "存在多个用户");
        }

        // 密码不匹配
        if (!cUsers.get(0).getPassword().equals(password)) {
            log.info("用户登录密码不正确");
            throw new CUserException(CUserException.PASSWORD_NOT_MATCH,"账号或密码不正确");
        }

        // 账号被冻结
        if (cUsers.get(0).getStatus() == 2) {
            log.info("账号被冻结");
            throw new CUserException(CUserException.ACCOUNT_LOCKED, "账号被冻结");
        }

        String uid = cUsers.get(0).getUid();
        // 赋值
        BeanUtils.copyProperties(cUsers.get(0), result);


        log.info("用户登录成功,{}", result);
        return result;
    }


    /**
     * 用户注册
     * 1.用户昵称必须唯一
     * 2.密码是前端将用户昵称和密码拼接md5之后得到的
     *
     * @Title addUser
     * @param username, password
     * @return java.lang.String
     * @throws CUserException
     */
    @Override
    public String addUser(String username, String password) throws CUserException{
        if (StringUtils.isEmpty(username.trim()) || StringUtils.isEmpty(password)) {
            throw new CUserException(CUserException.INPUT_PARAM_IS_NULL, "参数错误");
        }

        // 查询用户昵称是否已经存在
        List<CUser> cUsers = null;
        try {
            cUsers = userBiz.selectBy(username.trim(), null, null);
        } catch (CUserException e) {
            throw new CUserException(CUserException.DB_SELECT_ERROR.getCode(), e.getMsg());
        }

        if (cUsers != null && cUsers.size() > 0) {
            log.info("注册用户名已经存在");
            throw new CUserException(CUserException.ACCOUNT_ALREADY_EXIST, "账号已经存在");
        }


        // 注册
        try {
            String uid = userBiz.addUser(username, password);
            if (uid == null) {
                throw new CUserException(CUserException.DB_INSERT_RESULT_0.getCode(),"用户注册失败，没有拿到uid");
            }
            log.info("用户注册成功，uid:{}", uid);
            return uid;
        } catch (CUserException e) {
            log.error("用户注册失败",e);
            throw new CUserException(CUserException.DB_INSERT_RESULT_0.getCode(), e.getMessage());
        }
    }


    /**
     * 根据条件查询用户
     *
     * @Title selectBy
     * @param username, password, status
     * @return java.util.List<com.opsigte.chatroom.entity.CUser>
     * @throws CUserException
     */
    @Override
    public List<CUser> selectBy(String username, String password, Integer status) throws CUserException {
        try {
            List<CUser> cUsers = userBiz.selectBy(username, password, status);
            if (cUsers == null || cUsers.size() <= 0) {
                log.info("没有查询到用户");
                throw new CUserException(CUserException.DATA_IS_NULL, "没有根据条件查到用户");
            }
            return cUsers;
        } catch (CUserException e) {
            throw new CUserException(CUserException.DB_SELECT_ERROR.getCode(), e.getMsg());
        }
    }


    /**
     * 根据主键id查询用户
     *
     * @Title selectByPrimary
     * @param uid
     * @return com.opsigte.chatroom.entity.CUser
     * @throws CUserException
     */
    @Override
    public CUser selectByPrimary(String uid) throws CUserException {
        if (StringUtils.isEmpty(uid)) {
            throw new CUserException(CUserException.INPUT_PARAM_IS_NULL, "参数错误");
        }

        try {
            CUser cUser = userBiz.selectByPrimary(uid);
            if (cUser == null) {
                log.info("没有uid为:{}的用户",uid);
                throw new CUserException(CUserException.DATA_IS_NULL, "没有uid查到用户");
            }
            return cUser;
        } catch (CUserException e) {
            throw new CUserException(CUserException.DB_SELECT_ERROR.getCode(), e.getMsg());
        }
    }


}
