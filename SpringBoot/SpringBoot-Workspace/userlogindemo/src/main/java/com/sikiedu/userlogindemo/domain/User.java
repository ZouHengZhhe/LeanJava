package com.sikiedu.userlogindemo.domain;

import javax.persistence.*;

//实体要添加Entity注解
@Entity
public class User {
	//要有主键注解（@Id）和主键生成策略注解（自增-@GeneratedValue(strategy=GenerationType.IDENTITY)）
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String telephone;
	
	public User() {
		
	}
	
	public User(Long id, String username, String password, String telephone) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
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
	
	
}
