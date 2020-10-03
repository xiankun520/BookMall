package com.example.bookmall.Dao;

import com.example.bookmall.Pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UserAddressDao {

    ArrayList<Address> findUserAddress(@Param("user_id") String user_id);

    int addUserAddress(Address address);

    int deleteAddress(int rid);

    int selectAddress(@Param("user_id") String user_id,@Param("address") String address);
}
