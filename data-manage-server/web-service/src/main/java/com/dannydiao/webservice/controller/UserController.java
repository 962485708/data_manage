package com.dannydiao.webservice.controller;
/* Created By DiaoSu
   Date  2020/10/9
   Mail  diaosu@diaosudev.cn */

import com.dannydiao.webservice.feign.UserService;
import io.swagger.annotations.Api;
import network.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    BaseResponse<String> createUser(@RequestParam("userName") String userName,
                                    @RequestParam("userPassword") String userPassword,
                                    @RequestParam("userMail") String userMail){
        return userService.createUser(userName, userPassword, userMail);
    }

    @RequestMapping(value = "/getByMail", method = RequestMethod.GET)
    BaseResponse<?> getByMail(@RequestParam("userMail") String userMail){
        return userService.getByMail(userMail);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    BaseResponse<String> login(@RequestParam("userMail") String userMail,
                               @RequestParam("userPassword") String userPassword) {
        return userService.login(userMail, userPassword);
    }
}
