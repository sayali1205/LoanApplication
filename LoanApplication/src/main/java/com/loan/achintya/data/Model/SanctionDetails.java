package com.loan.achintya.data.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String fromEmail;
    private String custEmailId;
	@Lob
	private byte[] sanctionPdf;
}
