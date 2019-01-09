package com.opsigte.chatroom.biz;

import com.opsigte.chatroom.dao.CUserRelationDao;
import com.opsigte.chatroom.entity.CUserRelation;
import com.opsigte.chatroom.exception.BizException;
import com.opsigte.chatroom.exception.CUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: com.opsigte.chatroom.biz
 * @Class: UserRelationBiz
 * @Description: 用户关系业务处理类
 * @Author: opsigte
 * @Date: 2019/1/2 12:00
 * @version
 */
@Service
public class UserRelationBiz {

    private static final Logger log = LoggerFactory.getLogger(UserRelationBiz.class);

    @Autowired
    private CUserRelationDao cUserRelationDao;


    /**
     * 根据uid查询好友列表
     *
     * @Title selectListByUid
     * @param uid
     * @return java.util.List<com.opsigte.chatroom.entity.CUserRelation>
     * @throws CUserException
     */
    public List<CUserRelation> selectByUid(String uid) throws CUserException{
        try {
            log.info("查询好友列表参数,uid:{}", uid);
            return cUserRelationDao.selectByUid(uid);
        } catch (Exception e) {
            log.error("查询用户关系数据库异常",e);
            throw new CUserException(BizException.DB_SELECT_ERROR.getCode(), "查询用户关系数据库异常");
        }
    }


    /**
     * 添加好友
     *
     * @Title addRelation
     * @param sourceUid, targetUid
     * @return java.lang.String
     * @throws CUserException
     */
    @Transactional(rollbackFor = Exception.class)
    public String addRelation(String sourceUid, String targetUid) throws CUserException{
        CUserRelation cUserRelation = new CUserRelation(sourceUid,targetUid);
        cUserRelation.setVersion(1);
        cUserRelation.setCreateTime(new Date());
        cUserRelation.setUpdateTime(new Date());

        log.info("添加好友信息:{}", cUserRelation);
        try {
            cUserRelationDao.addRelation(cUserRelation);
            return cUserRelation.getRelationId();
        } catch (Exception e) {
            log.error("添加好友数据库失败,sourceUid:{},targetUid:{}",sourceUid,targetUid,e);
            throw new CUserException(CUserException.DB_INSERT_RESULT_0.getCode(), "添加好友数据库异常");
        }
    }


    /**
     * 根据源uid和目标uid查询relationId
     *
     * @Title selectRelationIdByUid
     * @param sourceUid, targetUid
     * @return java.lang.String
     * @throws CUserException
     */
    public String selectRelationIdByUid(String sourceUid, String targetUid) throws CUserException{
        try {
            Map<String, Object> map = new HashMap<String, Object>(16);
            map.put("sourceUid", sourceUid);
            map.put("targetUid", targetUid);
            return cUserRelationDao.selectRelationIdByUid(map);
        } catch (Exception e) {
            log.error("查询relationId数据库失败,sourceUid:{},targetUid:{}",sourceUid,targetUid,e);
            throw new CUserException(BizException.DB_SELECT_ERROR.getCode(), "查询relationId数据库异常");
        }
    }
}
