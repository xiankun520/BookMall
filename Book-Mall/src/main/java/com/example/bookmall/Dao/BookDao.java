package com.example.bookmall.Dao;

import com.example.bookmall.Pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface BookDao {

    ArrayList<Book> findAll();

    Book findById(@Param("isbn") String isbn);

}
