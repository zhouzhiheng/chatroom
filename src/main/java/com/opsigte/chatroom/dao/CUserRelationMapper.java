package com.opsigte.chatroom.dao;

import com.opsigte.chatroom.entity.CUserRelation;

public interface CUserRelationMapper {
    int insert(CUserRelation record);

    int insertSelective(CUserRelation record);
}