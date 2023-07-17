package com.loan.achintya.data.service;

import java.util.List;

import com.loan.achintya.data.model.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer cust);

	public List<Customer> getAllCustomer();

}
