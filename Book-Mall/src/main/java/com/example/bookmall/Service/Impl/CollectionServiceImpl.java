package com.example.bookmall.Service.Impl;

import com.example.bookmall.Dao.CollectionDao;
import com.example.bookmall.Pojo.Book;
import com.example.bookmall.Pojo.Collection;
import com.example.bookmall.Service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;

@Slf4j
@Service
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private CollectionDao collectionDao;

    @Override
    public int addCollection(Collection collection) {
        int i = collectionDao.addCollection(collection);
        return i;
    }

    @Override
    public int deleteCollection(Collection collection) {
        int i = collectionDao.deleteCollection(collection);
        return i;
    }

    @Override
    public ArrayList<Book> findAllCollections(String user_id) {
        ArrayList<Book> allCollections = collectionDao.findAllCollections(user_id);
        log.info(allCollections.toString());
        return allCollections;
    }
}
