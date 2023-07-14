package com.loan.achintya.data.service;

import com.loan.achintya.data.model.User;

public interface UserService {

	public User saveUser(User user);

	public User getByUnameAndPass(String uname, String pass);

	public User generateUnameAndPass(User user, String fromEmail);

}
