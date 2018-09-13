package com.example.demo1.model;

public class ErrorInfo<T> {
    public static final Integer OK = 0;// 0 表示成功
    public static final Integer ERROR = 100; // 100 表示发生错误

    private Integer code;
    private String message;
    private String url;
    private T data;

    public void setCode(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

}
