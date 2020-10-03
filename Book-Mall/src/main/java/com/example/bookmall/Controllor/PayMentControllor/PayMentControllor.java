package com.example.bookmall.Controllor.PayMentControllor;

import com.example.bookmall.Pojo.Order;
import com.example.bookmall.Pojo.User;
import com.example.bookmall.Pojo.util.payment;
import com.example.bookmall.Service.OrderDaoService;
import com.example.bookmall.Service.UserAddressDaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@Controller
public class PayMentControllor {
    //获取请求消息中的order_id,address,payment,更新订单的收货地址以及收件人信息
    //然后绑定order_id，payment，转发到下一个jsp payment.html
    //绑定order_id，payment处理支付是否成功

    //到达登录页面
    @Resource
    private UserAddressDaoService userAddressDaoService;
    
    @Resource
    private OrderDaoService orderDaoService;

    @PostMapping("/user/toPayMent")
    public String toPayMent(payment payment,
                            HttpServletRequest req,
                            Model model) {

        User user = (User) req.getSession().getAttribute("user");
        int i = userAddressDaoService.selectAddress(user.getPhone(), payment.getAddress());
        log.info("i="+i);
        if (i>0){
            payment.setRid(i);
        }
        System.out.println(payment.toString());
        model.addAttribute("payment",payment);
        return "user/page/payment";
    }

    //判断是否支付成功

    @PostMapping("/user/topayMentSuccess")
    public String topayMentSuccess(payment payment,Model model
    ,HttpServletRequest req){

        model.addAttribute("payment",payment);
        User user = (User) req.getSession().getAttribute("user");
        log.info("#######"+payment.getOrder_id());
        log.info("address_id="+payment.getRid());
        Order order=new Order();
        order.setAddress_id(payment.getRid());
        order.setPayment(88888);
        order.setUser_id(user.getPhone());
        order.setOrder_id(payment.getOrder_id());
        order.setPlaced(new Date());
        order.setReceipt(new Date());
        order.setSta("待发货");
        int i = orderDaoService.updateOrder(order);
        log.info("i="+i);
        return "user/page/pay-success";
    }


}