package com.loan.achintya.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCust() {
		
		return cs.getAllCustomer();
	}
	
}
