package com.opsigte.chatroom.dao;

import com.opsigte.chatroom.entity.CUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Project: com.opsigte.chatroom.dao
 * @Class: CUserDao
 * @Description: 用户dao
 * @Author: opsigte
 * @Date: 2019/1/2 11:12
 * @version
 */
@Repository
public interface CUserDao {
    /**
     * 插入一条用户信息
     *
     * @Title insert
     * @param cUser:用户对象
     * @return int
     * @throws Exception
     */
    int insert(CUser cUser) throws Exception;

    /**
     * 根据条件查询用户信息
     *
     * @Title selectBy
     * @param map
     * @return com.opsigte.chatroom.entity.CUser
     * @throws Exception
     */
    List<CUser> selectBy(Map<String, Object> map) throws Exception;


    /**
     * 根据uid主键查询用户信息
     *
     * @Title selectByPrimary
     * @param uid
     * @return com.opsigte.chatroom.entity.CUser
     * @throws Exception
     */
    CUser selectByPrimary(String uid) throws Exception;

    /**
     * 添加一个用户
     *
     * @Title addUser
     * @param cUser
     * @return void
     * @throws Exception
     */
    void addUser(CUser cUser) throws Exception;
}