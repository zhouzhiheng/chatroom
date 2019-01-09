package com.opsigte.chatroom.vo;

import java.io.Serializable;


/**
 * @Project: com.opsigte.chatroom.vo
 * @Class: ChatMessageParam
 * @Description: 存消息列表的入参
 * @Author: opsigte
 * @Date: 2019/1/9 17:56
 * @version
 */
public class ChatMessageParam implements Serializable {
    private static final long serialVersionUID = -4780647669814456225L;

    private String relationId;

    private String uid;

    private String msg;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ChatMessageParam{" +
                "relationId='" + relationId + '\'' +
                ", uid='" + uid + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
