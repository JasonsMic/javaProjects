package com.example.demo1.service;

import com.example.demo1.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/*
*
* */

public interface UserService {

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);

    List<User> selectAll();

}
