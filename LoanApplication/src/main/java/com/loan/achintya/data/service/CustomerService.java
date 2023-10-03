package com.loan.achintya.data.service;

import java.util.List;
import java.util.Optional;

import com.loan.achintya.data.model.BaseResponse;
import com.loan.achintya.data.model.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer cust);

	public List<Customer> getAllCustomer();

	public Customer getByid(int custId);

	public Optional<Customer> getByVerified(int custId);

	public List<Customer> getAllVerifiedCustomer();

	public Customer getCustByid(int custId);

	public Customer saveSCust(Customer c);

	public BaseResponse saveTransactionHistory(int userId);

	public void getSanction(int custId, String fromEmail);


}
