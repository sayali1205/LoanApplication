package com.loan.achintya.data.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import com.loan.achintya.data.model.User;
import com.loan.achintya.data.repository.UserRepository;
import com.loan.achintya.data.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private JavaMailSender ms;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}
	@Override
	public User getByUnameAndPass(String uname, String pass) {
		
		return userRepo.findByUsernameAndPassword(uname,pass);
	}
	@Override
	public User generateUnameAndPass(User user,String fromEmail) 
	{
		String userName=user.getFname()+user.getLname();
		String password=user.getLname()+user.getFname();
		user.setUsername(userName);
		user.setPassword(password);
		String text="Username="+user.getUsername()+"\n.....Password="+user.getPassword();
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(user.getToEmail());
		message.setFrom(fromEmail);
		message.setSubject(user.getUsername());
		message.setText(text);
		ms.send(message);
		return userRepo.save(user);
	}

}
