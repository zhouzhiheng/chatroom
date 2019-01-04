package com.opsigte.chatroom.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project: com.opsigte.chatroom.entity
 * @Class: CUserRelation
 * @Description: 用户关系实体
 * @Author: opsigte
 * @Date: 2019/1/2 10:06
 * @version
 */
public class CUserRelation implements Serializable {
    private static final long serialVersionUID = -1422481764369569547L;
    private String relationId;
    private String sourceUid;

    private String targetUid;

    private Integer version;

    private Date createTime;

    private Date updateTime;


    public CUserRelation() {
    }

    public CUserRelation(String sourceUid, String targetUid) {
        this.sourceUid = sourceUid;
        this.targetUid = targetUid;
    }


    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getSourceUid() {
        return sourceUid;
    }

    public void setSourceUid(String sourceUid) {
        this.sourceUid = sourceUid == null ? null : sourceUid.trim();
    }

    public String getTargetUid() {
        return targetUid;
    }

    public void setTargetUid(String targetUid) {
        this.targetUid = targetUid == null ? null : targetUid.trim();
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
        return "CUserRelation{" +
                "relationId='" + relationId + '\'' +
                ", sourceUid='" + sourceUid + '\'' +
                ", targetUid='" + targetUid + '\'' +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}