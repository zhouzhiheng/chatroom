package com.opsigte.chatroom.exception;

public class BizException extends RuntimeException {
    private static final long serialVersionUID = 820995519272913870L;

    public static final BizException DB_INSERT_RESULT_0 = new BizException(100544,"数据库操作,insert返回0", new Object[0]);
    public static final BizException DB_SELECT_ERROR = new BizException(100545,"数据库操作,select异常", new Object[0]);
    protected String msg;
    protected int code;

    public BizException(){

    }

    public BizException(int code,String msgFormat,Object... args){
        super(String.format(msgFormat,args));
        this.code = code;
        this.msg = String.format(msgFormat,args);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message) {
        super(message);
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }

    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }
}
