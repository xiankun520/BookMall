package com.example.bookmall.Dao;

import com.example.bookmall.Pojo.BookAndCart;
import com.example.bookmall.Pojo.Cart;
import com.example.bookmall.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface CartDao {
    int addCart(Cart cart);

    ArrayList<BookAndCart> findAllCart(User user);

    int updateCarCount(@Param("rid")int rid,@Param("num")int num);

    int deleteCartByRid(@Param("rid")Integer rid);
}
