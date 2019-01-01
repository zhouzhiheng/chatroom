package com.opsigte.chatroom.dao;

import com.opsigte.chatroom.entity.CUser;

public interface CUserMapper {
    int insert(CUser record);

    int insertSelective(CUser record);
}