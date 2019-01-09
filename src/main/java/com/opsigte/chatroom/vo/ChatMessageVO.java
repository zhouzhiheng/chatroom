package com.opsigte.chatroom.vo;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * @Project: com.opsigte.chatroom.vo
 * @Class: ChatMessageVO
 * @Description: 聊天记录
 * @Author: opsigte
 * @Date: 2019/1/8 18:41
 * @version
 */
@Document(collection = "messageList")
public class ChatMessageVO implements Serializable {
    private static final long serialVersionUID = 8902392109951138821L;

    /**
     * 关系id
     */
    @Indexed(unique = true)
    private String relationId;


    /**
     * 存的时候存一个对象，update.push()成了一个数组，所以要定义一个数组去接收
     */
    private ChatMessageInfoVO chatMessageInfoVO;

    /**
     * 定义数组去接收返回值
     */
    private List<ChatMessageInfoVO> list;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }


    public ChatMessageInfoVO getChatMessageInfoVO() {
        return chatMessageInfoVO;
    }

    public void setChatMessageInfoVO(ChatMessageInfoVO chatMessageInfoVO) {
        this.chatMessageInfoVO = chatMessageInfoVO;
    }

    public List<ChatMessageInfoVO> getList() {
        return list;
    }

    public void setList(List<ChatMessageInfoVO> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ChatMessageVO{" +
                "relationId='" + relationId + '\'' +
                ", chatMessageInfoVO=" + chatMessageInfoVO +
                ", list=" + list +
                '}';
    }
}
