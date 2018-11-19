package com.zhhe.smsdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-19 14:14
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自动加1
    private Long id;
    private String username;
    private String password;
    private String telephone;
    private String code;
    private Integer state;  //0表示未激活状态，1表示激活状态

    public User() {
    }

    public User(String username, String password, String telephone, String code, Integer state) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.code = code;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", code='" + code + '\'' +
                ", state=" + state +
                '}';
    }
}
