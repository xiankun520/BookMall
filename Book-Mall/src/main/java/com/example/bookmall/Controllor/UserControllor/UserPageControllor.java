package com.example.bookmall.Controllor.UserControllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserPageControllor {
//去登陆页面
    @GetMapping("/user/toUserLongin")
    public String touserLongin(){
        return "user/page/login";
    }
//去注册页面
    @GetMapping("/user/toRegister")
    public  String toRegister(){
        return "user/page/regist";
    }
//去首页
    @PostMapping("/user/toIndex")
    public  String toIndex(){
        return "user/page/index";
    }
//去收藏页面
    @GetMapping("/user/toCollect")
    public String toCollect(){
        return "user/page/collect";
    }
    //去订单页面
    @GetMapping("/user/toOrder")
    public String toOrdet(){
        return "/user/page/order";
    }
    //去购物车页面
    @GetMapping("/user/toCar")
    public String toCar(){
        return "user/page/cart";
    }
    //去设置页面
    @GetMapping("/user/toPasswordChange")
    public String toPasswordChange(){
        return "user/page/password-change";
    }

    //去帮助页面
    @GetMapping("/user/toHelp")
    public String toHelp(){
      return   "user/page/lookforward";
    }

    //去某本书的详情页面
    @GetMapping("/user/toDetail/{isbn}")
    public String toDetail(@PathVariable("isbn") String isbn, Model model){

        return "user/page/detail";
    }

}
