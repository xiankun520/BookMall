package com.example.bookmall.Service.Impl;

import com.example.bookmall.Dao.OrderDao;
import com.example.bookmall.Pojo.Confirm_Order;
import com.example.bookmall.Pojo.Order;
import com.example.bookmall.Pojo.orderItem;
import com.example.bookmall.Pojo.util.checkOrder;
import com.example.bookmall.Service.OrderDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class OrderDaoServiceImpl implements OrderDaoService {

    @Resource
    private OrderDao orderDao;
    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    public void saveOrderItem(orderItem orderItem) {
        orderDao.saveOrderItem(orderItem);
    }

    @Override
    public ArrayList<orderItem> findorderItem(int[] rid) {
        ArrayList<orderItem> orderItems = orderDao.findorderItem(rid);
        //System.out.println(orderItems.toString());
        return orderItems;
    }

    @Override
    public ArrayList<Confirm_Order> findConfirmOrder(String order_id) {
        ArrayList<Confirm_Order> confirmOrder = orderDao.findConfirmOrder(order_id);
        System.out.println(confirmOrder.toString());
        return confirmOrder;
    }

    @Override
    public int updateOrder(Order order) {
        int i = orderDao.updateOrder(order);
        return i;
    }

    @Override
    public ArrayList<checkOrder> findCheckOrderCount(String order_id) {
        ArrayList<checkOrder> checkOrder = orderDao.findCheckOrderCount(order_id);
        return checkOrder;
    }

    @Override
    public ArrayList<checkOrder> findCheckOrder(String user_id, int start, int length) {
        ArrayList<checkOrder> checkOrder = orderDao.findCheckOrder(user_id, start, length);
        return  checkOrder;
    }
}
