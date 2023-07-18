package com.loan.achintya.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LoanDetails {

	@Id
	private String loanStatus;
	private double requiredLoanamount;
}
