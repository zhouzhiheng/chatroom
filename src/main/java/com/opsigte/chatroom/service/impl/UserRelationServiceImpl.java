package com.opsigte.chatroom.service.impl;

import com.opsigte.chatroom.biz.UserRelationBiz;
import com.opsigte.chatroom.entity.CUser;
import com.opsigte.chatroom.entity.CUserRelation;
import com.opsigte.chatroom.exception.CUserException;
import com.opsigte.chatroom.service.UserRelationService;
import com.opsigte.chatroom.service.UserService;
import com.opsigte.chatroom.vo.UserRelationInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @Project: com.opsigte.chatroom.service.impl
 * @Class: UserRelationServiceImpl
 * @Description: 好友关系service实现
 * @Author: opsigte
 * @Date: 2019/1/4 14:21
 * @version
 */
@Service
public class UserRelationServiceImpl implements UserRelationService {

    private static final Logger log = LoggerFactory.getLogger(UserRelationServiceImpl.class);

    @Autowired
    private UserRelationBiz userRelationBiz;

    @Autowired
    private UserService userService;

    /**
     * 根据uid查询好友列表
     *
     * @Title selectListByUid
     * @param uid
     * @return java.util.List<com.opsigte.chatroom.entity.CUserRelation>
     * @throws CUserException
     */
    @Override
    public List<UserRelationInfoVO> selectListByUid(String uid) throws CUserException {
        if (StringUtils.isEmpty(uid)) {
            throw new CUserException(CUserException.INPUT_PARAM_IS_NULL, "参数错误");
        }

        // 查询用户好友列表
        List<CUserRelation> cUserRelations = null;
        try {
            cUserRelations = userRelationBiz.selectByUid(uid);
            if (cUserRelations == null || cUserRelations.size() <= 0) {
                log.info(" {} 用户没有好友", uid);
                throw new CUserException(CUserException.DATA_IS_NULL, "没有查询到好友列表");
            }
        } catch (CUserException e) {
            if (e.getCode() == CUserException.DATA_IS_NULL) {
                throw new CUserException(CUserException.DATA_REQUEST_SUCCESS_BUT_IS_NULL,"数据请求成功，但是没有记录");
            }
            throw new CUserException(CUserException.DB_SELECT_ERROR.getCode(), e.getMsg());
        }


        List<UserRelationInfoVO> userVOList = new ArrayList<UserRelationInfoVO>();

        // 循环查询用户好友信息
        // TODO 待优化
        for (CUserRelation cUserRelation : cUserRelations) {
            UserRelationInfoVO relationUser = new UserRelationInfoVO();
            String queryUid = "";
            try {
                // 判断，如果从好友列表中取出来的sourceUid不等于传进来的uid就根据sourceUid查；反之根据targetUid查
                if (!cUserRelation.getSourceUid().equals(uid)) {
                    queryUid = cUserRelation.getSourceUid();
                } else {
                    queryUid = cUserRelation.getTargetUid();
                }


                CUser cUser = userService.selectByPrimary(queryUid);
                if (cUser == null) {
                    throw new CUserException(CUserException.DATA_IS_NULL, "没有查到好友信息");
                }
                BeanUtils.copyProperties(cUser, relationUser);
                relationUser.setRelationId(cUserRelation.getRelationId());
                relationUser.setTargetUid(queryUid);
                relationUser.setUid(uid);

                userVOList.add(relationUser);
            } catch (CUserException e) {
                log.info("没有查询到好友信息，uid:{}", queryUid, e);
            }
        }

        return userVOList;
    }

    /**
     * 建立好友关系
     *
     * @Title addRelation
     * @param sourceUid, targetUid
     * @return java.lang.String
     * @throws CUserException
     */
    @Override
    public String addRelation(String sourceUid, String targetUid) throws CUserException {
        if (StringUtils.isEmpty(sourceUid) || StringUtils.isEmpty(targetUid)) {
            throw new CUserException(CUserException.INPUT_PARAM_IS_NULL, "参数错误");
        }

        if (sourceUid.equals(targetUid)) {
            log.info("添加好友列表时，源用户和目标用户id相同,sourceUid:{},targetUid:{}", sourceUid, targetUid);
            throw new CUserException(CUserException.RALATION_NOT_MYSELFT,"源用户和目标用户id相同");
        }


        // 查询是否存在源用户
        CUser sourceUser = null;
        try {
            sourceUser = userService.selectByPrimary(sourceUid);
        } catch (CUserException e) {
            log.error("添加好友时没有查询到sourceUid:{}的用户",sourceUid);
            throw new CUserException(CUserException.ACCOUNT_NOT_EXIST, "账号不存在");
        }

        // 目标账号被冻结
        if (sourceUser.getStatus() == 2) {
            log.error("目标账号被冻结,sourceUid:{}",sourceUid);
            throw new CUserException(CUserException.ACCOUNT_LOCKED, "账号被冻结");
        }


        // 查询是否存在目标用户
        CUser cUser = null;
        try {
            cUser = userService.selectByPrimary(targetUid);
        } catch (CUserException e) {
            log.error("添加好友时没有查询到targetUid:{}的用户",targetUid);
            throw new CUserException(CUserException.ACCOUNT_NOT_EXIST, "账号不存在");
        }

        // 目标账号被冻结
        if (cUser.getStatus() == 2) {
            log.error("目标账号被冻结,targetUid:{}",targetUid);
            throw new CUserException(CUserException.ACCOUNT_LOCKED, "账号被冻结");
        }


        // 添加好友关系
        try {
            String relationId = userRelationBiz.addRelation(sourceUid, targetUid);
            if (relationId == null) {
                log.info("添加好友关系失败，查询relationId为空");
                throw new CUserException(CUserException.DB_INSERT_RESULT_0.getCode(), "添加好友关系失败");
            }

            log.info("添加好友关系成功，relationId:{}", relationId);
            return relationId;
        } catch (CUserException e) {
            throw new CUserException(CUserException.DB_INSERT_RESULT_0.getCode(), e.getMsg());
        }
    }
}
