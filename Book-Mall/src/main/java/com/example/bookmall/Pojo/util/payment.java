package com.example.bookmall.Pojo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class payment {
    private  String order_id;
    private int rid;
    private String address;
    private Double payment;
}
