package com.loan.achintya.data.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.achintya.data.model.User;
import com.loan.achintya.data.repository.UserRepository;
import com.loan.achintya.data.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}
	@Override
	public User getByUnameAndPass(String uname, String pass) {
		
		return userRepo.findByUsernameAndPassword(uname,pass);
	}

}
