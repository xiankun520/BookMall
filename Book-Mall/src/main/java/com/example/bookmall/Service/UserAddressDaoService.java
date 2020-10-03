package com.example.bookmall.Service;

import com.example.bookmall.Pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserAddressDaoService {
    ArrayList<Address> findUserAddress(@Param("user_id") String user_id);

    int addUserAddress(Address address);

    int deleteAddress(int rid);

    int selectAddress(@Param("user_id") String user_id,@Param("address") String address);

}
