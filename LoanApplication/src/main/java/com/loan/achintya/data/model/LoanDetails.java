package com.loan.achintya.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetails {

	@Id

	private String loanStatus;
	private double requiredLoanamount;
}
