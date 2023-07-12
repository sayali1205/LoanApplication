package com.loan.achintya.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bankDetailId;
	private long accountNumber;
	private String bankName;
	private String bankIFSCCode;
	private double accountBalance;
	private String branch;

}
