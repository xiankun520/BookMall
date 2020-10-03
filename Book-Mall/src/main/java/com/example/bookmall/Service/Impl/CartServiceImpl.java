package com.example.bookmall.Service.Impl;

import com.example.bookmall.Dao.CartDao;
import com.example.bookmall.Pojo.BookAndCart;
import com.example.bookmall.Pojo.Cart;
import com.example.bookmall.Pojo.User;
import com.example.bookmall.Service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Slf4j
@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartDao cartDao;

    @Override
    public int addCart(Cart cart) {
        int i = cartDao.addCart(cart);
        return i;
    }

    @Override
    public ArrayList<BookAndCart> findAllCart(User user) {

        ArrayList<BookAndCart> allCart = cartDao.findAllCart(user);
        return allCart;
    }

    @Override
    public int updateCarCount(int rid, int num) {
        int i = cartDao.updateCarCount(rid, num);
        return i;
    }

    @Override
    public int deleteCartByRid(Integer rid) {
        int i = cartDao.deleteCartByRid(rid);
        return i;
    }
}
