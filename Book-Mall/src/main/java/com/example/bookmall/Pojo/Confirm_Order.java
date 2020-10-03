package com.example.bookmall.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Confirm_Order {
    private String title;
    private String press;
    private Double price;
    private int count;
    private String product;
    public String order_id;
}
