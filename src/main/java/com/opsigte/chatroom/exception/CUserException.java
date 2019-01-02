package com.opsigte.chatroom.exception;

/**
 * @Project: com.opsigte.chatroom.exception
 * @Class: CUserException
 * @Description: 用户异常类
 * @Author: opsigte
 * @Date: 2019/1/2 11:08
 * @version
 */
public class CUserException extends BizException {
    private static final long serialVersionUID = -7933806495874933389L;

    public static final int INPUT_PARAM_IS_NULL = 10032001;
    public static final int DATA_IS_NULL = 10032002;
    public static final int ACCOUNT_TOO_MANY = 10032003;
    public static final int PASSWORD_NOT_MATCH = 10032004;
    public static final int ACCOUNT_LOCKED = 10032005;
    public static final int ACCOUNT_NOT_EXIST = 10032006;
    public static final int ACCOUNT_ALREADY_EXIST = 10032007;

    public CUserException() {
    }

    public CUserException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public CUserException(int code, String msg) {
        super(code, msg, new Object[0]);
    }

}
