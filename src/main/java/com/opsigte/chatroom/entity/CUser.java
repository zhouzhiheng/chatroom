package com.opsigte.chatroom.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project: com.opsigte.chatroom.entity
 * @Class: CUser
 * @Description:  用户实体
 * @Author: opsigte
 * @Date: 2019/1/2
 * @version
 */
public class CUser implements Serializable {
    private static final long serialVersionUID = 864845347632803442L;
    private String uid;

    private String headUrl;

    /** 是否是会员 1是，2不是*/
    private Integer isMember;

    private Date lastLoginTime;

    private String niceName;

    private String password;

    /** 用户状态 1正常，2冻结*/
    private Integer status;

    private Integer version;

    private Date createTime;

    private Date updateTime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
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
        this.niceName = niceName == null ? null : niceName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CUser{" +
                "uid='" + uid + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", isMember=" + isMember +
                ", lastLoginTime=" + lastLoginTime +
                ", niceName='" + niceName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}