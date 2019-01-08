package com.opsigte.chatroom.vo;

import java.io.Serializable;

/**
 * @Project: com.opsigte.chatroom.vo
 * @Class: ChatMessageVO
 * @Description: 聊天记录
 * @Author: opsigte
 * @Date: 2019/1/8 18:41
 * @version
 */
public class ChatMessageVO implements Serializable {
    private static final long serialVersionUID = 8902392109951138821L;

    /**
     * 发送人uid
     */
    private String uid;

    private String msg;

    private String time;

    public ChatMessageVO() {
    }

    public ChatMessageVO(String uid, String msg, String time) {
        this.uid = uid;
        this.msg = msg;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChatMessageVO{" +
                "uid='" + uid + '\'' +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
