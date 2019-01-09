package com.opsigte.chatroom.dao;

import com.mongodb.client.result.UpdateResult;
import com.opsigte.chatroom.vo.ChatMessageInfoVO;
import com.opsigte.chatroom.vo.ChatMessageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TestChatMessageRepository {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testSave() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ChatMessageInfoVO chatMessageInfoVO = new ChatMessageInfoVO();
        chatMessageInfoVO.setUid("101010");
        chatMessageInfoVO.setMsg("发送消息2323");
        chatMessageInfoVO.setTime(sdf.format(new Date()));


        ChatMessageVO chatMessageVO = new ChatMessageVO();
        chatMessageVO.setRelationId("11111");
        chatMessageVO.setChatMessageInfoVO(chatMessageInfoVO);




        Update update = new Update();

        update.push("data", chatMessageVO.getChatMessageInfoVO());

        Query query = new Query();
        query.addCriteria(Criteria.where("relationId").is("11111"));

        UpdateResult upsert = mongoTemplate.upsert(query, update, ChatMessageVO.class);
        Sort sort = new Sort(Sort.Direction.DESC,"time");

        List<ChatMessageVO> chatMessageVOS = mongoTemplate.find(new Query(Criteria.where("relationId").is("11111")).with(sort), ChatMessageVO.class);
        for (ChatMessageVO chatMessage : chatMessageVOS) {
            System.out.println(chatMessage);
        }

    }



    @Test
    public void find(){
        Sort sort = new Sort(Sort.Direction.ASC,"time");

        List<ChatMessageVO> chatMessageVOS = mongoTemplate.find(new Query(Criteria.where("relationId").is("11111")).with(sort), ChatMessageVO.class);
        for (ChatMessageVO chatMessage : chatMessageVOS) {
            System.out.println(chatMessage);
        }

    }
}
