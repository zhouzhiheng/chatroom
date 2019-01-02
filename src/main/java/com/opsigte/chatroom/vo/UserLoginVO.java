package com.opsigte.chatroom.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Project: com.opsigte.chatroom.vo
 * @Class: UserLoginVO
 * @Description: 用户登录后返回的对象
 * @Author: opsigte
 * @Date: 2019/1/2 10:46
 * @version
 */
public class UserLoginVO implements Serializable {
    private static final long serialVersionUID = 4900716718759325378L;

    private String uid;

    private String headUrl;

    /** 是否是会员 1是，2不是*/
    private Integer isMember;

    private Date lastLoginTime;

    private String niceName;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Integer getIsMember() {
        return isMember;
    }

    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    @Override
    public String toString() {
        return "UserLoginVO{" +
                "uid='" + uid + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", isMember=" + isMember +
                ", lastLoginTime=" + lastLoginTime +
                ", niceName='" + niceName + '\'' +
                '}';
    }
}
