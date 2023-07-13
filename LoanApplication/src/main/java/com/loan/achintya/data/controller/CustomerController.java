package com.loan.achintya.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.achintya.data.model.Customer;
import com.loan.achintya.data.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	
	CustomerService cs;
	
	@PostMapping("/saveCust")
	public Customer saveCustomer(@RequestBody Customer cust)
	{
		return cs.saveCustomer(cust) ;
	}
	
}
