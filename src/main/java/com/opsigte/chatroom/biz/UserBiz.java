package com.opsigte.chatroom.biz;

import com.opsigte.chatroom.dao.CUserDao;
import com.opsigte.chatroom.entity.CUser;
import com.opsigte.chatroom.exception.BizException;
import com.opsigte.chatroom.exception.CUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: com.opsigte.chatroom.biz
 * @Class: UserBiz
 * @Description: 用户业务处理类，一个方法只写一个业务，在service中组装返回
 * @Author: opsigte
 * @Date: 2019/1/2 11:05
 * @version
 */
@Service
public class UserBiz {
    private static final Logger log = LoggerFactory.getLogger(UserBiz.class);

    @Autowired
    private CUserDao cUserDao;

    /**
     * 根据username，password，status查询用户信息
     *
     * @Title login
     * @param username, password,status
     * @return com.opsigte.chatroom.entity.CUser
     * @throws CUserException
     */
    public List<CUser> selectBy(String username,String password,Integer status) throws CUserException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (username != null && !StringUtils.isEmpty(username)) {
            map.put("username", username);
        }
        if (password != null && !StringUtils.isEmpty(password)) {
            map.put("password", password);
        }
        if (status != null && !StringUtils.isEmpty(status)) {
            map.put("status", status);
        }

        log.info("查询用户信息参数：map:{}",map);

        try {
            return cUserDao.selectBy(map);
        } catch (Exception e) {
            log.error("查询用户信息数据库异常",e);
            throw new CUserException(CUserException.DB_SELECT_ERROR.getCode(), "查询用户信息数据库异常");
        }
    }



    /**
     * 根据uid查询用户信息
     *
     * @Title selectByUid
     * @param uid
     * @return com.opsigte.chatroom.entity.CUser
     * @throws
     */
    public CUser selectByPrimary(String uid) throws CUserException{
        try {
            return cUserDao.selectByPrimary(uid);
        } catch (Exception e) {
            log.error("根据主键查询用户信息数据库异常,uid:{}",uid,e);
            throw new CUserException(CUserException.DB_SELECT_ERROR.getCode(), "根据主键查询用户信息数据库异常");
        }
    }


    /**
     * 添加一个用户
     *
     * @Title addUser
     * @param username, password
     * @return java.lang.String
     * @throws CUserException
     */
    @Transactional()
    public String addUser(String username, String password) throws CUserException{
        CUser cUser = new CUser();
        cUser.setNiceName(username.trim());
        cUser.setPassword(password);
        cUser.setHeadUrl("");
        cUser.setIsMember(2);
        cUser.setLastLoginTime(null);
        cUser.setStatus(1);
        cUser.setVersion(1);
        cUser.setCreateTime(new Date());
        cUser.setUpdateTime(new Date());

        try {
            cUserDao.addUser(cUser);
            String uid = cUser.getUid();
            if (uid == null) {
                throw new CUserException(CUserException.DB_INSERT_RESULT_0.getCode(), "插入用户数据失败");
            }
            return uid;
        } catch (Exception e) {
            log.error("添加用户数据库异常",e);
            throw new CUserException(CUserException.DB_INSERT_RESULT_0.getCode(), e.getMessage());
        }
    }
}
