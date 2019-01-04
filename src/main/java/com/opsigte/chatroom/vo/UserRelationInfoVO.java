package com.opsigte.chatroom.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project: com.opsigte.chatroom.vo
 * @Class: UserRelationInfoVO
 * @Description: 用户好友列表信息
 * @Author: opsigte
 * @Date: 2019/1/2 10:46
 * @version
 */
public class UserRelationInfoVO implements Serializable {
    private static final long serialVersionUID = 4900716718759325378L;

    private String uid;

    private String headUrl;

    /** 是否是会员 1是，2不是*/
    private Integer isMember;

    private Date lastLoginTime;

    private String niceName;

    private String relationId;

    private String targetUid;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getTargetUid() {
        return targetUid;
    }

    public void setTargetUid(String targetUid) {
        this.targetUid = targetUid;
    }

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
        return "UserRelationInfoVO{" +
                "uid='" + uid + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", isMember=" + isMember +
                ", lastLoginTime=" + lastLoginTime +
                ", niceName='" + niceName + '\'' +
                ", relationId='" + relationId + '\'' +
                ", targetUid='" + targetUid + '\'' +
                '}';
    }
}
