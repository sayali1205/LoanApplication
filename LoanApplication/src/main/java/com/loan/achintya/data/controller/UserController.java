package com.loan.achintya.data.controller;

import java.io.IOException;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.achintya.data.model.User;
import com.loan.achintya.data.service.UserService;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	UserService us;
	
	@Value(value="${spring.mail.username}")
	String fromEmail;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestParam ("data") String json,@RequestParam("profilePhoto")MultipartFile profilePhoto,
			@RequestParam("signature") MultipartFile signature) throws IOException, JsonProcessingException {
		ObjectMapper om=new ObjectMapper();
		User user=om.readValue(json, User.class);
		user.setProfilePhoto(profilePhoto.getBytes());
		user.setSignature(signature.getBytes());
		return us.saveUser(user);
	}
	
	@PostMapping("/generateUnameAndPassAndSendMail")
	public User generateUnameAndPass(@RequestBody User user) {
		
		return us.generateUnameAndPass(user,fromEmail);
	}
	
	@GetMapping("/logincheck/{username}/{password}")
	public User logincheck(@PathVariable("username")String uname,@PathVariable ("password") String pass) {
		
		return us.getByUnameAndPass(uname,pass);
	}
}