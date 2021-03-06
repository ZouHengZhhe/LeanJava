package com.sikiedu.userlogindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sikiedu.userlogindemo.domain.User;
import com.sikiedu.userlogindemo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/index.action")
	public ModelAndView index() {
		return new ModelAndView("/index.html");
	}
	
	@RequestMapping("/user/register.action")
	public ModelAndView register(User user) {
		
		System.out.println(user.getUsername()+"///"+user.getPassword());
//		System.out.println("register函数已经运行");
		userRepository.save(user);
		
//		return new ModelAndView("/index.html");   //转发
		return new ModelAndView("redirect:/index.action");   //重定向到另一个Controller
	}
}
