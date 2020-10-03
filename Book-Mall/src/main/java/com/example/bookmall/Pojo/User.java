package com.example.bookmall.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String uname;
    private String upwd;
    private String email;
    private String phone;
    private int role;
}
