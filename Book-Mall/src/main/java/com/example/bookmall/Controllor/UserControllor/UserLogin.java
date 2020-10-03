package com.example.bookmall.Controllor.UserControllor;

import com.example.bookmall.Pojo.User;
import com.example.bookmall.Service.UserDaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class UserLogin {

    @Resource
    private UserDaoService userDaoService;

    @RequestMapping("/user/login")
    public String Login(@RequestParam("uname") String uname,
                        @RequestParam("upwd") String upwd, HttpServletRequest request){
        User user = userDaoService.checkUser(uname, upwd);
        if (user!=null){
            System.out.printf("dddddddddddddd");
            request.getSession().setAttribute("user",user);
            return "redirect:/book/findall";
        }else {
            return "redirect:/user/toUserLongin";
        }
    }


}
