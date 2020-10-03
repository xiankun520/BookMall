package com.example.bookmall.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address  {
    private int rid;
    private String user_id;
    private String address;
    private Date added;
    private String receiver;
    private String receiver_phone;
}
