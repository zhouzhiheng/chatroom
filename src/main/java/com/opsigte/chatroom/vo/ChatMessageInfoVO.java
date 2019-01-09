package com.opsigte.chatroom.vo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Project: com.opsigte.chatroom.vo
 * @Class: ChatMessageInfoVO
 * @Description: 聊天记录详细信息
 * @Author: opsigte
 * @Date: 2019/1/9 14:23
 * @version
 */
public class ChatMessageInfoVO implements Serializable {
    private static final long serialVersionUID = -3305461610388657079L;

    /**
     * 发送人uid
     */
    private String uid;

    private String msg;

    private String time;




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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChatMessageInfoVO{" +
                "uid='" + uid + '\'' +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
