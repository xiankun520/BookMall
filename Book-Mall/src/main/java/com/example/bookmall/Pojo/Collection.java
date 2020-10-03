package com.example.bookmall.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collection {
    private String user_id;//对应用户手机号
    private String product;//对应书的id
}
