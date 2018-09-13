package com.example.demo1.model;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "devconfig")
public class ServerConfigModel {
    private String ip;
    private String port;


    public String getIp(){
        return this.ip;
    }
    public void setIp(String ip){
        this.ip = ip;
    }

    public String getPort(){
        return this.port;
    }
    public void setPort(String port){
        this.port = port;
    }
}
