package com.example.bookmall.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int rid;  //记录编号           主键
    private String user_id; //用户编号   user.phone
    private  String order_id;//订单编号 手机后3位+当前时间
    private  String sta;//订单状态    待处理
    private  int address_id;//收货地址
    public double payment;//支付金额
    private Date placed;//下单时间
    private Date receipt;//接单时间
    private  Date deliver;//发货时间
    private  Date handover;//交付时间
}
