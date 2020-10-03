package com.example.bookmall.Pojo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class checkOrder {

    private double price;
    public int count;
    private String order_id;;//订单编号 手机后3位+当前时间
    private  String sta;//订单状态    待处理
    private  int address_id;//收货地址
    public double payment;//支付金额
    private Date receipt;//下单时间
    private String title;
    private String press;
    private String isbn;
}
