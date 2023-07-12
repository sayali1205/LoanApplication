package com.loan.achintya.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.achintya.data.model.User;
import com.loan.achintya.data.service.UserService;

import lombok.Data;
@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	UserService us;
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		
		return us.saveUser(user);
	}
	@GetMapping("/logincheck/{username}/{password}")
	public User logincheck(@PathVariable("username")String uname,@PathVariable ("password") String pass) {
		
		return us.getByUnameAndPass(uname,pass);
	}
}
