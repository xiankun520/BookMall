package com.example.bookmall.Service;

import com.example.bookmall.Pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDaoService {
    void addUser(User user);

    void updateUser(User user);

    User  checkUname(@Param("uname") String uname);

    User  checkEmail(@Param("email") String email);

    User checkPhone(@Param("phone") String phone);

    User checkUser(@Param("uname") String uname,
                   @Param("upwd") String upwd);
}
