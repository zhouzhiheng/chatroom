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
     * @return String
     * @throws Exception
     */
    void addRelation(CUserRelation cUserRelation) throws Exception;

    /**
     * 根据uid查询好友列表
     *
     * @Title selectByUid
     * @param uid
     * @return java.util.List<com.opsigte.chatroom.entity.CUserRelation>
     * @throws Exception
     */
    List<CUserRelation> selectByUid(String uid) throws Exception;



}