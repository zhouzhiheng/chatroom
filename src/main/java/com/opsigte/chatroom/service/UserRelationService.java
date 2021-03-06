package com.opsigte.chatroom.service;


import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.vo.UserRelationInfoVO;

import java.util.List;

/**
 * @Project: com.opsigte.chatroom.service
 * @Class: UserRelationService
 * @Description: 用户关系service
 * @Author: opsigte
 * @Date: 2019/1/4 11:14
 * @version
 */
public interface UserRelationService {


    /**
     * 根据uid查询好友列表
     *
     * @Title selectListByUid
     * @param uid
     * @return java.util.List<com.opsigte.chatroom.entity.CUserRelation>
     * @throws CUserException
     */
    List<UserRelationInfoVO> selectListByUid(String uid) throws CUserException;


    /**
     * 建立好友关系
     *
     * @Title addRelation
     * @param sourceUid, targetUid
     * @return java.lang.String
     * @throws CUserException
     */
    String addRelation(String sourceUid, String targetUid) throws CUserException;

    /**
     * 根据源uid和目标uid查询relationId
     *
     * @Title selectRelationIdByUid
     * @param sourceUid, targetUid
     * @return java.lang.String
     * @throws CUserException
     */
    String selectRelationIdByUid(String sourceUid, String targetUid) throws CUserException;
}
