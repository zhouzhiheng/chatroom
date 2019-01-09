package com.opsigte.chatroom.service.impl;

import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.service.ChatMessageService;
import com.opsigte.chatroom.utils.WebToolkit;
import com.opsigte.chatroom.vo.ChatMessageInfoVO;
import com.opsigte.chatroom.vo.ChatMessageParam;
import com.opsigte.chatroom.vo.ChatMessageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Project: com.opsigte.chatroom.service.impl
 * @Class: ChatMessageServiceImpl
 * @Description: 聊天消息持久化service实现类
 * @Author: opsigte
 * @Date: 2019/1/9 17:38
 * @version
 */
@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    private static final Logger log = LoggerFactory.getLogger(UserRelationServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据relationId查询消息列表
     *
     * @Title findByRelationId
     * @param relationId
     * @return java.util.List<com.opsigte.chatroom.vo.ChatMessageVO>
     * @throws Exception
     */
    @Override
    public List<ChatMessageVO> findByRelationId(String relationId) throws Exception {
        try {
            return mongoTemplate.find(new Query(Criteria.where("relationId").is(relationId)), ChatMessageVO.class);
        } catch (Exception e) {
            log.error("根据relationId查询mongo消息列表异常,relationId:{}",relationId, e);
            throw new CUserException(CUserException.DB_SELECT_ERROR.getCode(), "查询mongo消息列表异常");
        }
    }


    /**
     * 更新或添加数据
     *
     * @Title upsert
     * @param chatMessageParam
     * @return boolean
     * @throws CUserException
     */
    @Override
    public boolean addMessage(ChatMessageParam chatMessageParam) throws CUserException {
        if (chatMessageParam == null || StringUtils.isEmpty(chatMessageParam.getRelationId())) {
            throw new CUserException(CUserException.INPUT_PARAM_IS_NULL, "参数错误");
        }

        ChatMessageVO chatMessageVO = new ChatMessageVO();
        chatMessageVO.setRelationId(chatMessageParam.getRelationId());

        ChatMessageInfoVO chatMessageInfoVO = new ChatMessageInfoVO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        chatMessageInfoVO.setTime(sdf.format(new Date()));
        chatMessageInfoVO.setMsg(WebToolkit.delHTMLTag(chatMessageParam.getMsg()));
        chatMessageInfoVO.setUid(chatMessageParam.getUid());

        chatMessageVO.setChatMessageInfoVO(chatMessageInfoVO);

        Update update = new Update();
        update.push("list", chatMessageVO.getChatMessageInfoVO());

        Query query = new Query();
        query.addCriteria(Criteria.where("relationId").is(chatMessageParam.getRelationId()));


        try {
            return mongoTemplate.upsert(query, update, chatMessageVO.getClass()).wasAcknowledged();
        } catch (Exception e) {
            log.error("向mongodb数据库添加消息异常,relationId:{}",chatMessageParam.getRelationId(),e);
            throw new CUserException(CUserException.DB_INSERT_RESULT_0.getCode(), "添加消息失败");
        }
    }
}
