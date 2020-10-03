package com.example.bookmall.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class orderItem {
    private int rid;
    private String product;
    private double price;
    public int count;
    public String order_id;

}
