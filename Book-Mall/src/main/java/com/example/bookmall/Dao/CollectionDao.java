package com.example.bookmall.Dao;

import com.example.bookmall.Pojo.Book;
import com.example.bookmall.Pojo.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface CollectionDao {


    int addCollection(Collection collection);

    int deleteCollection(Collection collection);

    ArrayList<Book> findAllCollections(@Param("user_id") String user_id);
}
