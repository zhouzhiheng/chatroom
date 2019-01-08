package com.opsigte.chatroom.mongodb;

import com.opsigte.chatroom.vo.ChatMessageVO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessageVO,Long> {


}
