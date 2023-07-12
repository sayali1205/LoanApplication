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
	private int BankId;
	

}
