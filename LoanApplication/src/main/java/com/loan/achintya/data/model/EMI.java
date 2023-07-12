package com.loan.achintya.data.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EMI {
	 private double principal;
	    private double annualInterestRate;
	    private int tenure;
	 }  


