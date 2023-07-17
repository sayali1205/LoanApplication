package com.loan.achintya.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EMI {

	 private double principal;
	    private double annualInterestRate;
	    private int tenureInMonths;
	    private double emi;
	 }  


