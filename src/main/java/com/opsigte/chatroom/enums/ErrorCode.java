package com.opsigte.chatroom.enums;

public enum ErrorCode {

    /**
     * 系统错误
     */
    SYSTEM_CODE(500, "系统错误"),
    /**
     * 成功请求（有数据）
     */
    SUCCESS_CODE(200, "数据请求成功"),
    /**
     * 成功请求（没数据）
     */
    DATA_IS_NULL(204,"没有查询到数据"),
    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXIST(301, "账号不存在"),
    /**
     * 账号或密码不正确
     */
    ACCOUNT_PASSWORD_NOT_MATCH(302, "账号或密码不正确"),
    /**
     * 账号无效
     */
    ACCOUNT_NOT_VALID(303, "账号无效"),
    /**
     * 账号被冻结
     */
    ACCOUNT_LOCKED(304, "账号被冻结"),
    /**
     * 账号已经存在
     */
    ACCOUNT_ALREADY_EXIST(305, "账号已经存在"),
    /**
     * 参数传入错误
     */
    PARAM_ERROR(101, "参数传入错误"),

    ;

    private final Integer value;
    private final String message;

    ErrorCode(Integer value,String message){
        this.value = value;
        this.message = message;
    }

    public int getValue(){
        return value;
    }

    public String getMessage(){
        return message;
    }

    public String getCode(){
        return value.toString();
    }
    @Override
    public String toString() {
        return value.toString();
    }
}
