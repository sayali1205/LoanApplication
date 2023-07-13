package com.loan.achintya.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.achintya.data.model.Customer;
import com.loan.achintya.data.model.EMI;
@Repository
public interface LoanRepository extends JpaRepository<Customer, Integer> {

}
