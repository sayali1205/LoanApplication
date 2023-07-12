package com.loan.achintya.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.achintya.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsernameAndPassword(String uname, String pass);

}
