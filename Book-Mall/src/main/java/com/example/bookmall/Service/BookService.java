package com.example.bookmall.Service;

import com.example.bookmall.Pojo.Book;


import java.util.ArrayList;

public interface BookService {

    ArrayList<Book> findAll();

    Book findById(String isbn);
}
