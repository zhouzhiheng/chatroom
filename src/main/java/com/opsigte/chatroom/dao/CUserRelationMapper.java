package com.opsigte.chatroom.dao;

import com.opsigte.chatroom.entity.CUserRelation;
import com.opsigte.chatroom.entity.CUserRelationExample;
import java.util.List;

public interface CUserRelationMapper {
    int insert(CUserRelation record);

    int insertSelective(CUserRelation record);

    List<CUserRelation> selectByExample(CUserRelationExample example);
}