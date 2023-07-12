package com.loan.achintya.data.Model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class BankDetails {

	@Id
	private int bankDetailId;
	private long accountNumber;
	private String bankName;
	private String bankIFSCCOde;
	private double accountBalance;
	

}
