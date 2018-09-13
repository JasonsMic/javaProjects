package com.example.demo1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class User implements Serializable {

    private Integer userId;

    private String userName;

    private String password;

    private String phone;

    @JsonProperty
    public Integer getUserId(){
        return this.userId;
    }

    public void setUserName(String name){
        this.userName = name;
    }
    @JsonProperty
    public String getUserName(){
        return this.userName;
    }

    public void setPassword(String password){
        this.password = password;
    }
    @JsonProperty
    public String getPassword(){
        return this.password;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    @JsonProperty
    public String getPhone(){
        return this.phone;
    }

}
