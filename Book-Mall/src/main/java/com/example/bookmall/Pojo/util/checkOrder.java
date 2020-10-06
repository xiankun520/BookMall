package com.example.bookmall.Pojo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class checkOrder {
    private String title;
    private String isbn;
    private String press;
    private int count;
    private double price;
    private String orderId;//订单编号 手机后3位+当前时间
    private String sta;//订单状态    待处理
    private Date receipt;//下单时间
    private int addressId;//收货地址
    private double payment;//支付金额

}
