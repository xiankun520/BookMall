package com.example.bookmall.Service.Impl;

import com.example.bookmall.Dao.UserAddressDao;
import com.example.bookmall.Pojo.Address;
import com.example.bookmall.Service.UserAddressDaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class UserAddressDaoServiceImpl implements UserAddressDaoService {
    @Resource
    private UserAddressDao userAddressDao;

    @Override
    public ArrayList<Address> findUserAddress(String user_id) {
        ArrayList<Address> userAddress = userAddressDao.findUserAddress(user_id);
        return userAddress;
    }

    @Override
    public int addUserAddress(Address address) {
        int i = userAddressDao.addUserAddress(address);
        return i;
    }

    @Override
    public int deleteAddress(int rid) {
        int i = userAddressDao.deleteAddress(rid);
        return i;
    }

    @Override
    public int selectAddress(String user_id, String address) {
        int i = userAddressDao.selectAddress(user_id, address);
        return i;
    }
}
