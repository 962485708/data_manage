package com.dannydiao.userservice.service;
/* Created By DiaoSu
   Date  2020/10/9
   Mail  diaosu@diaosudev.cn */

import com.dannydiao.userservice.dao.UserRepository;
import com.dannydiao.userservice.entity.User;
import com.google.gson.Gson;
import jwt.JWTUtil;
import network.response.BaseResponse;
import network.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public BaseResponse<String> createUser(String userName, String userPassword, String userMail) {
        User user = new User(userName, userPassword, userMail);
        try {
            //先检查是否邮箱已存在
            if (userRepository.findByMail(userMail) != null) {
                return new BaseResponse<>(ResponseCode.DUPLICATE, "");
            } else {
                userRepository.save(user);
                return new BaseResponse<>(ResponseCode.SUCCESS, "");
            }
        } catch (Exception e) {
            return new BaseResponse<>(ResponseCode.DUPLICATE, "");
        }
    }

    public BaseResponse<User> getUser(String mail) {
        try {
            User user = userRepository.findByMail(mail);
            return new BaseResponse<>(ResponseCode.SUCCESS, user);
        } catch (Exception e) {
            return new BaseResponse<>(ResponseCode.NO_ERROR, new User());
        }
    }

    public BaseResponse<String> login(String userMail, String userPassword) {
        try {
            User user = userRepository.findByMail(userMail);
            if (user == null) {
                return new BaseResponse<>(ResponseCode.NO_ERROR, "");
            } else {
                if (!user.getPassword().equals(userPassword)) {
                    return new BaseResponse<>(ResponseCode.AUTH_ERROR, "");
                } else {
                    String subject = new Gson().toJson(user);
                    String jwt = null;
                    try {
                        Map<String, Object> map = new HashMap<>();
                        map.put("userName", user.getName());
                        map.put("userMail", user.getMail());
                        jwt = JWTUtil.createJWT("DiaoSu", subject, map);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return new BaseResponse<>(ResponseCode.SUCCESS, jwt);
                }
            }
        } catch (Exception e) {
            return new BaseResponse<>(ResponseCode.SERVER_ERROR, "");
        }

    }
}
