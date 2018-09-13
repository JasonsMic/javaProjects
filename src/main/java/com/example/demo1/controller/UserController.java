package com.example.demo1.controller;


import com.example.demo1.model.Response;
import com.example.demo1.model.ServerConfigModel;
import com.example.demo1.model.User;
import com.example.demo1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
/*
* Created by jason
* **/
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    /*可以获取到yml 配置的端口号，根据key 获取到值。*/
    @Value("${server.port}")
    private String port;

    @Value("${content}")
    private String content;

    @Autowired
    private ServerConfigModel serverConfigModel;

    @Resource
    private UserService userService;


    @RequestMapping("/getServerConfig")
    public String getServerConfig(){
        return "将yml的配置与javaBean结合使用的结果：ip="+serverConfigModel.getIp()+"   port = "+serverConfigModel.getPort();
    }

    @RequestMapping("/getPort")
    public String getPort(){

        return port;
    }

    @RequestMapping(value = {"/getContent","/getContents"},method = RequestMethod.POST)
    public String getContent(){
        return content;
    }

    @RequestMapping("/delUser")
    public String deleteUser(HttpServletRequest request){

        return "删除成功";
    }

    @RequestMapping("/add")
    public String addUser(){
        User user = new User();
        user.setPhone("1000011");
        user.setUserName("联通");
        user.setPassword("liantong.net");
        logger.info("-------------开始插入----------------");
        int isSuccess = userService.addUser(user);
        if (isSuccess > 0) {
            return "success";
        }else{
            return "failed";
        }

    }

    @GetMapping("/all")
    public Object findAllUsers(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                       int pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize){
        return userService.findAllUser(pageNum,pageSize);

    }

    @RequestMapping("/getUserAll")
    public Response<List<User>> getUserAll(){
        Response<List<User>> res = new Response();
        List<User> list = userService.selectAll();
        res.setCode(200);
        res.setMessage("正常");
        res.setData(list);
        for (User user : list) {
            System.out.println(user.getUserId()+"**"+user.getUserName()+"**"+user.getPassword()+"**"+user.getPhone());
        }
        res.setAllData(list,200,"success");
        return res;
    }

}
