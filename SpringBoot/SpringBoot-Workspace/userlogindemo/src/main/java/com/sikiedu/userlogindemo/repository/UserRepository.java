package com.sikiedu.userlogindemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sikiedu.userlogindemo.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	//遵循Spring data jpa 命名标准
	User findByUsernameAndPassword(String username,String password);
	
}
