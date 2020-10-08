package com.dannydiao.userservice.dao;
/* Created By DiaoSu
   Date  2020/10/9
   Mail  diaosu@diaosudev.cn */


import com.dannydiao.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByMail(String mail);
}
