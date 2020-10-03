package com.example.bookmall.Service.Impl;

import com.example.bookmall.Dao.BookDao;
import com.example.bookmall.Pojo.Book;
import com.example.bookmall.Service.BookService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    @Cacheable(cacheNames = {"allbook"})
    @Override
    public ArrayList<Book> findAll() {
        ArrayList<Book> all = bookDao.findAll();
        return all;
    }

    @Cacheable(cacheNames = "book")
    @Override
    public Book findById(String isbn) {
        Book byId = bookDao.findById(isbn);
        return byId;
    }
}
