package com.example.bookmall.Controllor.UserControllor;

import com.example.bookmall.Pojo.User;
import com.example.bookmall.Service.UserDaoService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserControllor {

    @Autowired
    private UserDaoService userDaoService;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/user/register")
    public String registerUser(User user){
        userDaoService.addUser(user);
        return "redirect:/user/toUserLongin";
    }

    /**
     *
     * @param phone
     * @return 检测手机号是否被注册
     */
    @ResponseBody
    @PostMapping("/user/checkPhone/{phone}")
    public String checkEmail(@RequestBody @PathVariable("phone") String phone){
        log.info("----------"+phone);
//        System.out.printf(phone);
        User user = userDaoService.checkPhone(phone);
//        System.out.printf(user.toString());
        if (user!=null){
            System.out.printf("no");
            return "no";
        }else {
            System.out.printf("yes");
            return "yes";
        }
    }

    /**
     *
     * @param email
     * @return 检测邮箱是否被注册
     */
    @ResponseBody
    @PostMapping("/user/checkEmail/{email}")
    public String ckeckEmail(@RequestBody @PathVariable("email") String email){
        log.info("**********"+email);
        User user = userDaoService.checkEmail(email);
        if (user!=null){
            return "yes";
        }else {
            return "no";
        }
    }

    /**
     *
     * @param uname
     * @return 检测用户名是否被占用
     */
    @ResponseBody
    @PostMapping("/user/checkUname/{uname}")
    public String checkUname(@RequestBody @PathVariable("uname") String uname){
        log.info("**********"+uname);
        User user = userDaoService.checkUname(uname);
        if(user!=null){
            return "yes";
        }else {
            return "no";
        }
    }

    @GetMapping("/user/loginOut")
    public String loginOut(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return "user/page/login";

    }


}
