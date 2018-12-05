package com.zhhe.smsdemo.serviceimpl;

import com.zhhe.smsdemo.domain.User;
import com.zhhe.smsdemo.repository.UserRepository;
import com.zhhe.smsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-19 14:32
 */
@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void changeUserState(String telephone, String username, String password) {
        userRepository.changeUserState(telephone, username, password);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public User findUserByUsernameAndPasswordAndTelephone(String username, String password, String telephone) {
        return userRepository.findUserByUsernameAndPasswordAndTelephone(username, password, telephone);
    }
}
