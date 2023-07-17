package com.loan.achintya.data.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.achintya.data.model.Customer;
import com.loan.achintya.data.repository.CustomerRepository;
import com.loan.achintya.data.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	
	CustomerRepository cr;
	
	@Override
	public Customer saveCustomer(Customer cust) {
		
		return cr.save(cust);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return cr.findAll();
		
	}

}
