package com.example.demo1.controller;

import com.example.demo1.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常测试类
 *
 * */
@RestController
@RequestMapping("/api")
//controller层模拟异常的controller
public class GlobalController {

    @RequestMapping("/error")
    public ResponseEntity<?> testError()throws CustomException {
        throw new CustomException("这个是一个自定义异常");
    }

}
