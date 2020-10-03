package com.example.bookmall.Controllor.CartControllor;


import com.example.bookmall.Service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Controller
public class UpdateControllor {

    @Resource
    private CartService cartService;
    /**
     * 利用Ajax
     * 进行购物车的宝贝数量进行加操作
     */

    @ResponseBody
    @GetMapping("/user/updateCarCount")
public void  addCount(@RequestParam("rid") String rid,
                      @RequestParam("num") String num){

        int rid1=Integer.parseInt(rid);
        int num1=Integer.parseInt(num);
        log.info(rid1+"********"+num1);

        cartService.updateCarCount(rid1, num1);
           log.info("########################");

    }

//    @GetMapping("/user/decreaseCarCount")
//    public void  decreaseCarCount(@RequestBody @RequestParam("rid") int rid,
//                          @RequestParam("num") int num){
//
//
//
//    }

}
