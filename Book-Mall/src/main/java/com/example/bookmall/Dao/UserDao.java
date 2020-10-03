package com.example.bookmall.Dao;

import com.example.bookmall.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    /**
     *
     * @param user 添加用户和用户信息的更改
     */
    void addUser(User user);

    void updateUser(User user);

    /**
     *
     * @param uname
     * @return  check用户注册信息
     */
    User  checkUname(@Param("uname") String uname);

    User  checkEmail(@Param("email") String email);

    User checkPhone(@Param("phone") String phone);

    User checkUser(@Param("uname") String uname,@Param("upwd") String upwd);
}
