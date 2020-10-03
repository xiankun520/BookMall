package com.example.bookmall.Service;

import com.example.bookmall.Pojo.Confirm_Order;
import com.example.bookmall.Pojo.Order;
import com.example.bookmall.Pojo.orderItem;
import com.example.bookmall.Pojo.util.checkOrder;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface OrderDaoService {

    void saveOrder(Order order);

    void saveOrderItem(orderItem orderItem);

    ArrayList<orderItem> findorderItem(int rid[]);

    ArrayList<Confirm_Order> findConfirmOrder(@Param("order_id") String order_id);

    int updateOrder(Order order);

    ArrayList<checkOrder>  findCheckOrder(@Param("order_id") String order_id);
}
