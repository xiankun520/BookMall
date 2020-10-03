package com.example.bookmall.Controllor.CartControllor;


import com.example.bookmall.Pojo.BookAndCart;
import com.example.bookmall.Pojo.Cart;
import com.example.bookmall.Pojo.User;
import com.example.bookmall.Service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Slf4j
@Controller
public class AddCarControllor {

    @Resource
    private CartService cartService;


    @ResponseBody
    @PostMapping("/user/addCart")
    public  String addCart(@RequestBody Cart cart,
                           HttpServletRequest req){
        HttpSession session = req.getSession();
//        log.info(cart.toString());
        User user= (User) session.getAttribute("user");
        cart.setUser_id(user.getPhone());
        int i = cartService.addCart(cart);
        if (i>0){
            return "yes";
        }else {
            return "no";
        }
    }

    @GetMapping("/user/findAllCart")
    public  String findAllCart(HttpServletRequest request,
                               Model model){
        /**
         * 从session中或得user
         * 得到购物车条目到ArrayList<BookAndCart>
         *
         */
        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
        ArrayList<BookAndCart> allCart = cartService.findAllCart(user);
        model.addAttribute("allcart",allCart);
        for (int i = 0; i < allCart.size(); i++) {
           log.info("***"+allCart.get(i).getRid());
            System.out.printf("********");
        }
        log.info(allCart.toString());
        return "user/page/cart";
    }

    @GetMapping("/user/deleteCartByRid")
    public String deleteCartByRid(@RequestParam("rid")String rid){
        int rid1= Integer.parseInt(rid);
        int i = cartService.deleteCartByRid(rid1);
        if (i>0){
            log.info("删除购物车宝贝rid="+rid1);
            return "redirect:/user/findAllCart";
        }else {
            log.info("删除失败");
            return "redirect:/user/findAllCart";
        }
    }

}
