package com.opsigte.chatroom.mongodb;

import com.opsigte.chatroom.vo.ChatMessageVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessageVO,Long> {

    List<ChatMessageVO> findByUid(String uid);
}
