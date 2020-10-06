package com.example.bookmall;

import com.example.bookmall.Pojo.Book;
import com.example.bookmall.Pojo.Confirm_Order;
import com.example.bookmall.Pojo.orderItem;
import com.example.bookmall.Pojo.util.checkOrder;
import com.example.bookmall.Service.BookService;
import com.example.bookmall.Service.OrderDaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;

@SpringBootTest
class BookMallApplicationTests {

    @Test
    void contextLoads() {
        System.out.printf("sss");
    }

    @Resource
  private   BookService bookService;
    @Test
    void BookTest01(){

        ArrayList<Book> all = bookService.findAll();
        for (int i = 0; i <all.size() ; i++) {
            System.out.printf(all.get(i).toString());
        }

    }

    @Resource
    private OrderDaoService orderDaoService;
    @Test
    void orderItem(){
        int rid[]=new int[]{1,2,3};
        ArrayList<orderItem> orderItems = orderDaoService.findorderItem(rid);
        System.out.println(orderItems.toString());
    }

    @Test
    void checkOrder(){
        ArrayList<checkOrder> checkOrder = orderDaoService.findCheckOrderCount("12345678900");
        for (int i = 0; i <checkOrder.size() ; i++) {
            System.out.println(checkOrder.get(i).toString());
        }
    }

    @Test
    void findorder(){
        ArrayList<checkOrder> checkOrder = orderDaoService.findCheckOrder("12345678900", 0, 5);
//        System.out.println(checkOrder.get(1).getOrder_id());
        for (int i = 0; i <checkOrder.size() ; i++) {
            System.out.println(checkOrder.get(i).toString());
        }
    }
    
    @Test
    void confirmOrder(){
        String order_id="900201005114138";
        ArrayList<Confirm_Order> confirmOrder = orderDaoService.findConfirmOrder(order_id);
        for (int i = 0; i < confirmOrder.size(); i++) {
            System.out.println(confirmOrder.get(i).toString());
        }
    }

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void RedisTemplate(){
        redisTemplate.opsForValue().set("name","xiankun");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

}
