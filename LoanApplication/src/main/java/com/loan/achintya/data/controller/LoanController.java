package com.loan.achintya.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.achintya.data.model.EMI;
import com.loan.achintya.data.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	LoanService ls;
	
	@PostMapping("/CalculateEmi")
	public double EmiCalculator(@RequestBody EMI emi) {
		
		return ls.emiCalculate(emi);
	}
}
