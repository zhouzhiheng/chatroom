package com.opsigte.chatroom.service;

import com.opsigte.chatroom.vo.ChatMessageParam;
import com.opsigte.chatroom.vo.ChatMessageVO;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @Project: com.opsigte.chatroom.service
 * @Class: ChatMessageService
 * @Description: 聊天消息持久化service
 * @Author: opsigte
 * @Date: 2019/1/9 17:37
 * @version
 */
public interface ChatMessageService {

    /**
     * 根据relationId查询消息列表
     *
     * @Title findByRelationId
     * @param relationId
     * @return java.util.List<com.opsigte.chatroom.vo.ChatMessageVO>
     * @throws Exception
     */
    List<ChatMessageVO> findByRelationId(String relationId) throws Exception;

    /**
     * 更新或添加数据
     *
     * @Title upsert
     * @param chatMessageParam
     * @return boolean
     * @throws Exception
     */
    boolean addMessage(ChatMessageParam chatMessageParam) throws Exception;
}
