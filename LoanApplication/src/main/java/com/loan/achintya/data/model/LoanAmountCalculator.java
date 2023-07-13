package com.loan.achintya.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LoanAmountCalculator {

	@Id
	private double EMI;
	private float interest;
	private int loanTenture;
	private double feesAndCharges;
	
	
}
