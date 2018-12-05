package com.zhhe.smsdemo.repository;

import com.zhhe.smsdemo.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-19 14:28
 */
public interface UserRepository extends CrudRepository<User,Long> {
    @Query(value = "update user u set u.state=1 where u.telephone=?1 and u.username=?2 and u.password=?3",nativeQuery = true)
    @Modifying
    void changeUserState(String telephone,String username,String password);

    User findUserByUsernameAndPassword(String username , String password);

    User findUserByUsernameAndPasswordAndTelephone(String username,String password,String telephone);
}
