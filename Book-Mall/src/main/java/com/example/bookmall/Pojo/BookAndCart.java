package com.example.bookmall.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 混合视图层
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookAndCart {
    private String isbn;
    private String title;
    private String author;
    private Double price;
    private String press;
    private int edition;
    private Date published;
    private int pages;
    private int words;
    private String packaging;
    private String format;
    private String form;

    private  int rid;
    private String user_id;//对应用户手机号
    private String product;//对应书的id
    private int count;
}
