package com.dannydiao.webservice.feign;
/* Created By DiaoSu
   Date  2020/10/9
   Mail  diaosu@diaosudev.cn */

import network.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface UserService {
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    BaseResponse<String> createUser(@RequestParam("userName") String userName,
                                    @RequestParam("userPassword") String userPassword,
                                    @RequestParam("userMail") String userMail);


    @RequestMapping(value = "/getByMail", method = RequestMethod.GET)
    BaseResponse<?> getByMail(@RequestParam("userMail") String userMail);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    BaseResponse<String> login(@RequestParam("userMail") String userMail,
                               @RequestParam("userPassword") String userPassword);
}
