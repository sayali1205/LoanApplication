package com.loan.achintya.data.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.achintya.data.model.Customer;
import com.loan.achintya.data.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	
	CustomerService cs;
	
	@PostMapping(value="/saveCust",produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer saveCustomer(@RequestPart(value="pancard")MultipartFile pan,
			@RequestPart(value="adharCard")MultipartFile adhar,
			@RequestPart(value="photo")MultipartFile photo,
			@RequestPart(value="signature")MultipartFile signature,
			@RequestPart(value="form16")MultipartFile form16,
			@RequestPart(value="itr")MultipartFile itr,
			@RequestPart(value="data") String json ) throws Exception
	{
		
		ObjectMapper om=new ObjectMapper();
		Customer c=om.readValue(json, Customer.class);
		c.getDocData().setPancard(pan.getBytes());
		c.getDocData().setAdharCard(adhar.getBytes());
		c.getDocData().setPhoto(photo.getBytes());
		c.getDocData().setSignature(signature.getBytes());
		c.getDocData().setForm16(form16.getBytes());
		c.getDocData().setItr(itr.getBytes());
		return cs.saveCustomer(c) ;
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCust() {
		
		return cs.getAllCustomer();
	}
	
}
