package com.loan.achintya.data.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int transId;
//	private String transType;
//	@CreationTimestamp
//	private Date transDate;
//	private double transAmount;
//	private double remainingBalance;
	private int transactionId;
	@CreationTimestamp
	private Date transactionDate;
	
	private double transactionAmount;
	
	private double remainningAccountBalance;
	

}
