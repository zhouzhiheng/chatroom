package com.opsigte.chatroom.service.impl;

import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.service.UserRelationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UserRelationServiceImplTest {

    @Autowired
    private UserRelationService userRelationService;

    // 测试 添加好友关系
    @Test
    public void testAddRelation(){
        try {
            System.out.println("=====>"+userRelationService.addRelation("7cf7ebe8-0e65-11e9-833e-309c233cd1e5", "eec384a3-0e64-11e9-833e-309c233cd1e5"));
        } catch (CUserException e) {
            System.out.println(e.getMsg());
        }
    }

}
