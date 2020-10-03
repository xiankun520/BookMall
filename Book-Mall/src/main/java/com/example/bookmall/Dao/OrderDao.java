package com.example.bookmall.Dao;

import com.example.bookmall.Pojo.Confirm_Order;
import com.example.bookmall.Pojo.Order;
import com.example.bookmall.Pojo.orderItem;
import com.example.bookmall.Pojo.util.checkOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface OrderDao {

    /**
     * 保存订单
     */
    void saveOrder(Order order);

    /**
     *     从购物车cart中查询出若干条记录，每一条记录包含“商品编号 商品数量 商品价格”
     *     然后用这些数据封装出若干个orderItem，这些对象的order_id都的当前order的order_id，
     *     并把这些对象持久化保存
     */
    ArrayList<orderItem> findorderItem(int rid[]);

    /**
     *   4.使用请求信息中的所有orderItem的id和CartDao的XXX方法查询出若干个
     *  “商品的编号，商品的数量，商品价格”的对象组成的集合。进行封装（orderItem并持久化保存,
     */

    void saveOrderItem(orderItem orderItem);

    ArrayList<Confirm_Order> findConfirmOrder(@Param("order_id") String order_id);


    int updateOrder(Order order);

    ArrayList<checkOrder>  findCheckOrder(@Param("user_id") String user_id);




}
