package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 操作控制器
 *
 * @author jason
 *
 *
 * */
@RestController
@RequestMapping("/operator")
public class OperatorController {

    /*private static final Logger logger = Logger.getLogger(OperatorController.class);*/

    @RequestMapping("/one")
    public String operatorMethodOne(){
        return "operatorMethodOne";
    }

}
