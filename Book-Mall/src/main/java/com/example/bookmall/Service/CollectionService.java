package com.example.bookmall.Service;

import com.example.bookmall.Pojo.Book;
import com.example.bookmall.Pojo.Collection;

import java.util.ArrayList;

public interface CollectionService {

    int addCollection(Collection collection);

    int deleteCollection(Collection collection);

    ArrayList<Book> findAllCollections(String user_id);
}
