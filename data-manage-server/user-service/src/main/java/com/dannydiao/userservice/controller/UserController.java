package com.dannydiao.userservice.controller;
/* Created By DiaoSu
   Date  2020/10/8
   Mail  diaosu@diaosudev.cn */

import network.response.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    BaseResponse<String> createUser(@RequestParam("userName") String userName,
                                    @RequestParam("userPassword") String userPassword,
                                    @RequestParam("userMail") String userMail) {
        return null;
    }
}
