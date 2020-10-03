package com.example.bookmall.Controllor.addressControllor;

import com.example.bookmall.Pojo.Address;
import com.example.bookmall.Pojo.User;
import com.example.bookmall.Service.UserAddressDaoService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class UserAddressControllor {
    @Resource
    private UserAddressDaoService userAddressDaoService;

    /**
     * 去用户添加地址界面
     *
     * @param
     * @return
     */
    @GetMapping("/user/toAddUserAddress")
    public String toAddUserAddress() {
        return "user/page/address-add";
    }

    /**
     * 用户添加地址
     *
     * @param address 用户添加的地址
     * @param
     * @return
     */

    @ResponseBody
    @PostMapping("/user/addUserAddress")
    public String addUserAddress(@RequestBody String address,
                                 HttpServletRequest req) {
//处理前台的序列化字符串
        String[] split = address.split("&");
        int length = split.length;
        String addressMsg[] = new String[length];
        for (int i = 0; i < split.length; i++) {
            addressMsg[i] = split[i].split("=")[1];
        }
        Address add = new Address();
        for (int i = 0; i < addressMsg.length; i++) {
            /**
             *   前端：js中
             *   原因：.serialize()自动调用了encodeURIComponent方法将数据编码了
             *   解决方法：调用decodeURIComponent(XXX,true);将数据解码
             *   String name = getHttpServletRequest().getParameter("name");
             * n  ame = URLDecoder.decode(name, "UTF-8");
             */
            try {
                add.setReceiver(URLDecoder.decode(addressMsg[0],"UTF-8"));
                add.setAddress(URLDecoder.decode(addressMsg[1],"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            add.setReceiver_phone(addressMsg[2]);
        }
        log.info(address.toString());
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        add.setUser_id(user.getPhone());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = sdf.format(new Date());
        add.setAdded(new Date());

        int i = userAddressDaoService.addUserAddress(add);
//        int i=0;
        if (i > 0) {
            return "yes";
        } else {
            return "no";
        }

    }

}
