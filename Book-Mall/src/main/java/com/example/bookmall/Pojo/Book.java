package com.example.bookmall.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
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
}
