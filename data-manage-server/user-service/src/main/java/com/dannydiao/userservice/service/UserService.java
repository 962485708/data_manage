package com.dannydiao.userservice.service;
/* Created By DiaoSu
   Date  2020/10/9
   Mail  diaosu@diaosudev.cn */

import com.dannydiao.userservice.dao.UserRepository;
import com.dannydiao.userservice.entity.User;
import network.response.BaseResponse;
import network.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    BaseResponse<String> createUser(String userName, String userPassword, String userMail) {
        User user = new User(userName, userPassword, userMail);
        try {
            userRepository.save(user);
            return new BaseResponse<>(ResponseCode.SUCCESS, "");
        } catch (Exception e) {
            return new BaseResponse<>(ResponseCode.DUPLICATE, "");
        }
    }

    BaseResponse<User> getUser(String mail) {
        try {
            User user = userRepository.findByMail(mail);
            return new BaseResponse<>(ResponseCode.SUCCESS, user);
        } catch (Exception e) {
            return new BaseResponse<>(ResponseCode.NO_ERROR, new User());
        }
    }
}
