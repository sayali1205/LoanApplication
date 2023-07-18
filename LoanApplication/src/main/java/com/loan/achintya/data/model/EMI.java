package com.loan.achintya.data.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	 }  


