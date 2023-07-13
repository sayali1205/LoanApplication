package com.loan.achintya.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanctionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sanctionId;
	private String loanType;
	private double loanAmountSanctioned;
	private int tenureInYearSanctioned;
    private double monthlyEmi;
    private String custEmailId;
    private String disbursementStatus;
	@Lob
	private byte[] sanctionPdf;
}
