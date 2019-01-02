package com.opsigte.chatroom.biz;

import com.opsigte.chatroom.dao.CUserRelationDao;
import com.opsigte.chatroom.exception.BizException;
import com.opsigte.chatroom.exception.CUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<String> selectByUid(String uid) throws CUserException{
        try {
            log.info("查询好友列表参数,uid:{}", uid);
            return cUserRelationDao.selectByUid(uid);
        } catch (Exception e) {
            log.error("查询用户关系数据库异常",e);
            throw new CUserException(BizException.DB_SELECT_ERROR.getCode(), "查询用户关系数据库异常");
        }
    }

}
