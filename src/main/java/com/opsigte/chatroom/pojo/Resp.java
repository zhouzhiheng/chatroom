package com.opsigte.chatroom.pojo;

import com.opsigte.chatroom.enums.ErrorCode;

import java.io.Serializable;

public class Resp<T> implements Serializable {
    private static final long serialVersionUID = 8491473530179413416L;

    private String code;

    private String message;

    private T data;


    public Resp() {
    }

    public Resp(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public Resp(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Resp success() {
        return new Resp<>(ErrorCode.DATA_IS_NULL.getCode(), ErrorCode.DATA_IS_NULL.getMessage(), null);
    }

    public static <T> Resp success(T data){
        return new Resp<>(ErrorCode.SUCCESS_CODE.getCode(), ErrorCode.SUCCESS_CODE.getMessage(), data);
    }

    public static <T> Resp success(String code,String message,T data){
        return new Resp<>(code,message, data);
    }
    public static <T> Resp fail(){
        return new Resp<>(ErrorCode.SYSTEM_CODE.getCode(), ErrorCode.SYSTEM_CODE.getMessage(), null);
    }
    public static <T> Resp fail(String code,T data){
        return new Resp<>(code, ErrorCode.SYSTEM_CODE.getMessage(), data);
    }
    public static <T> Resp fail(String code ,String mesage,T data){
        return new Resp<>(code, mesage, data);
    }
}
