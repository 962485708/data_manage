package com.dannydiao.webservice;
/* Created By DiaoSu
   Date  2020/10/10
   Mail  diaosu@diaosudev.cn */


import network.request.LogInInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInInterceptor()).excludePathPatterns("/user/login","/swagger-ui.html","/user/create","/webjars/springfox-swagger-ui/**","/swagger-resources/**");
        super.addInterceptors(registry);
    }
}
