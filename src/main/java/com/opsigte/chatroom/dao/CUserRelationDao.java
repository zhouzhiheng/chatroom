package com.opsigte.chatroom.dao;

import com.opsigte.chatroom.entity.CUserRelation;

import java.util.List;

/**
 * @Project: com.opsigte.chatroom.dao
 * @Class: CUserRelationDao
 * @Description: 用户关系dao
 * @Author: opsigte
 * @Date: 2019/1/2 12:05
 * @version
 */
public interface CUserRelationDao {
    /**
     * 插入一条用户关系
     *
     * @Title insert
     * @param cUserRelation
     * @return int
     * @throws Exception
     */
    int insert(CUserRelation cUserRelation) throws Exception;

    /**
     * 根据源uid查询好友uid
     *
     * @Title selectByUid
     * @param uid
     * @return java.util.List<java.lang.String>
     * @throws Exception
     */
    List<String> selectByUid(String uid) throws Exception;



}