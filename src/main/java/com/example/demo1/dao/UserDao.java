package com.example.demo1.dao;

import com.example.demo1.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    int insert(User record);

    List<User> selectUsers();

    List<User> selectAll();
}
