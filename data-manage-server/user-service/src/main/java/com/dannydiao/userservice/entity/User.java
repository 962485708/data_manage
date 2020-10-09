package com.dannydiao.userservice.entity;
/* Created By DiaoSu
   Date  2020/10/9
   Mail  diaosu@diaosudev.cn */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class User {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String mail;

    public User(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
