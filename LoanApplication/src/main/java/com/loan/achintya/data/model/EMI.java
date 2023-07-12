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
public class EMI {
	@Id
	private int emiId;
	 private double principal;
	    private double annualInterestRate;
	    private int tenure;
	 }  


