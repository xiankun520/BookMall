package com.example.bookmall.Controllor.orderControllor;

import com.example.bookmall.Pojo.*;
import com.example.bookmall.Pojo.util.checkOrder;
import com.example.bookmall.Service.OrderDaoService;
import com.example.bookmall.Service.UserAddressDaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
@Controller
public class OrderControllor {


    @Resource
    private OrderDaoService orderDaoService;

    @Resource
    private UserAddressDaoService userAddressDaoService;

    /**
     * 获取购物车中的相关数据，生成一个订单
     * 1.获得请求信息中的字符串数组，获得session中的user
     * 2.new order();
     * 3.order对象的持久化
     * 4.使用请求信息中的所有orderItem的id和CartDao的XXX方法查询出若干个
     * “商品的编号，商品的数量，商品价格”的对象组成的集合。进行封装（orderItem并持久化保存,
     * 每个对象的order_id设置为当前的订单的order_id）
     * 5.绑定order_id并转发到confirmControllor中
     */
    @GetMapping("/user/cartToOrder")//转发
    public String cartToOrder(@RequestParam String rids[],
                              HttpServletRequest req,
                              Model model) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Order order = new Order();
        order.setUser_id(user.getPhone());
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        order.setOrder_id(user.getPhone().substring(8) + sdf.format(new Date()));
        order.setSta("待处理");
        //持久化
        orderDaoService.saveOrder(order);

        int length = rids.length;
        int rid[] = new int[length];
        for (int i = 0; i < rids.length; i++) {
            rid[i] = Integer.parseInt(rids[i]);
        }
        ArrayList<orderItem> orderItems = orderDaoService.findorderItem(rid);
        for (int i = 0; i < orderItems.size(); i++) {
            orderItem orderItem = orderItems.get(i);
            orderItem.setOrder_id(order.getOrder_id());
            orderDaoService.saveOrderItem(orderItem);
        }

//        model.addAttribute("order_id", order.getOrder_id());
        req.setAttribute("order_id", order.getOrder_id());
        return "forward:/user/orderConfirm";
    }

    /**
     * 订单的确定，查询出所有的地址 ，以及订单的相关信息，然后转发到order_confirm.html
     */

    @GetMapping("/user/orderConfirm")
    public String orderConfirm(HttpServletRequest req,
                               Model model) {
        /**1.从请求信息中获得order_id,从session中获得user
         * 2.查询出所有的地址，然后组成一个集合
         * 3.根据订单id获取订单下面的所有条目里面是若干个orderItemAndBookAndOrder
         * 4.绑定：所有地址的集合，order_id,一个集合，里面是若干个orderItemAndBookAndOrder
         * 5.然后转发到order_confirm.html
         */
        String order_id = (String) req.getAttribute("order_id");
        log.info("********"+order_id);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Address> userAddress = userAddressDaoService.findUserAddress(user.getPhone());
        ArrayList<Confirm_Order> confirmOrder = orderDaoService.findConfirmOrder(order_id);
        model.addAttribute("addresses", userAddress);
        model.addAttribute("confirmOrder",confirmOrder);
        model.addAttribute("order_id",order_id);
        return "user/page/order-confirm";
    }
    /**
     * 不考虑分页的情况下：
     * 1.获得session中的user对象
     * 2.根据user中的手机号查出若干条数据，每条数据包括
     *  order_id,place,isbn,title,press,price,count,sta
     *  将这些数据封装成若干个orderItemAndBookAndOrder对象，存储在集合中
     *  3.将这些集合绑定到request中，然后转发到order.jsp  分页的情况：
     *  1.要实现分页查询，就要确定几个变量
     *  length:每一条显示几条
     *  tatalcount:一共有多少条记录，查询得来
     *  pagecount:totalcount/length+1
     *  current:当前页，默认是第一页
     *  2.通过mysql的分页查询，查询出若干个对象组成集合
     *  3.将这些数据绑定再转发
     */

    @GetMapping("/user/chechOrder")
    public String ChechOrder(HttpServletRequest req,Model model){
        User user = (User) req.getSession().getAttribute("user");
        ArrayList<checkOrder> checkOrder = orderDaoService.findCheckOrderCount(user.getPhone());
        int count=checkOrder.size();//总数
        //每一页显示的行数，默认是10行
        String lengthStr = req.getParameter("request")==null?"5":req.getParameter("request");
        int length = Integer.parseInt(lengthStr);
        //从第几行记录开始显示(也就是每一页的第一行记录是总的记录的第几行)，默认是第一行
        String startStr = req.getParameter("start")==null?"0": req.getParameter("start");
        int start = Integer.parseInt(startStr);
        //第几页，默认是第一页
        String currentStr = req.getParameter("current")==null?"1":req.getParameter("current");
        int current = Integer.parseInt(currentStr);
        int pageCount=0;
        if(count%length==0){
            pageCount = count/length+1;
        }else {
             pageCount = count/length+1;
        }
        ArrayList<checkOrder> checkOrder1 = orderDaoService.findCheckOrder(user.getPhone(), start, length);

        model.addAttribute("length",length);
        model.addAttribute("start",start);
        model.addAttribute("current",current);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("checkOrder",checkOrder1);
        return "user/page/order";
    }
}
