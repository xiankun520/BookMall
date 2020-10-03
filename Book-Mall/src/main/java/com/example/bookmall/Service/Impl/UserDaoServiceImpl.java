package com.example.bookmall.Service.Impl;

import com.example.bookmall.Dao.UserDao;
import com.example.bookmall.Pojo.User;
import com.example.bookmall.Service.UserDaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDaoServiceImpl implements UserDaoService {

    @Resource
  private  UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User checkUname(String uname) {
        User user = userDao.checkUname(uname);
        return user;
    }

    @Override
    public User checkEmail(String email) {
        User user = userDao.checkEmail(email);
        return user;
    }

    @Override
    public User checkPhone(String phone) {
        User user = userDao.checkPhone(phone);
        return user;
    }


    @Override
    public User checkUser(String uname, String upwd) {
        User user = userDao.checkUser(uname, upwd);
        return user;
    }
}
