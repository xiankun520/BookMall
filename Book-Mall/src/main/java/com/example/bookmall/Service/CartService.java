package com.example.bookmall.Service;

import com.example.bookmall.Pojo.BookAndCart;
import com.example.bookmall.Pojo.Cart;
import com.example.bookmall.Pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface CartService {

    int addCart(Cart cart);

    ArrayList<BookAndCart> findAllCart(User user);

    int updateCarCount(@Param("rid")int rid, @Param("num")int num);

    int deleteCartByRid(@Param("rid")Integer rid);
}
