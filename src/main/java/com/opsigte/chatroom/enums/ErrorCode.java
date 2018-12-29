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
