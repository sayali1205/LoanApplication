package com.loan.achintya.data.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	private int adrId;
	private String localAddress;
	private String permanentAddress;
	
}
