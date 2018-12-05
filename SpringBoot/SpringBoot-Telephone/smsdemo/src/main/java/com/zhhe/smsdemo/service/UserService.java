package com.zhhe.smsdemo.service;

import com.zhhe.smsdemo.domain.User;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-19 14:29
 */
public interface UserService {

    void save(User user);

    void changeUserState(String telephone,String username,String password);

    User findUserByUsernameAndPassword(String username,String password);

    User findUserByUsernameAndPasswordAndTelephone(String username,String password,String telephone);
}
