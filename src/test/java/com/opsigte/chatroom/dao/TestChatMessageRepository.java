package com.opsigte.chatroom.dao;

import com.opsigte.chatroom.mongodb.ChatMessageRepository;
import com.opsigte.chatroom.vo.ChatMessageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TestChatMessageRepository {


    @Autowired
    private ChatMessageRepository chatMessageRepository;


    @Test
    public void testSave(){
        ChatMessageVO chatMessageVO = new ChatMessageVO("111","222向111发送消息","2018-01-08 19:02:30");
        chatMessageRepository.save(chatMessageVO);

        List<ChatMessageVO> byUid = chatMessageRepository.findByUid("111");
        for (ChatMessageVO chatMessageVO1 : byUid) {
            System.out.println(chatMessageVO1);
        }

        /*List<ChatMessageVO> all = chatMessageRepository.findAll();
        for (ChatMessageVO chatMessageVO1 : all) {
            System.out.println(chatMessageVO1);
        }*/

    }
}
