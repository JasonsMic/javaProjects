package com.example.demo1.model;

public class Response<T> {

    /*数据*/
    private T data;
    /*状态码*/
    private Integer code;
    /*状态信息*/
    private String message;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


    public void setAllData(T data, Integer code, String message, Object... args) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public void setAllData(T data, Integer code, String message) {
        setAllData(data, code, message, null);
    }

    public void setAllData(Integer code, String message) {
        this.setAllData(null, code, message);
    }

    public void setOriginalData(Integer code, String message, T data) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

}
