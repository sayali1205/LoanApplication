package com.loan.achintya.data.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {
	@Id
	private int custId;
	private String custFirstName;
	private String custLastName;
	private long custContactNo;
	private String custEmailId;
	private String custPANno;
	private String custLoanType;
	private double custLoanAmmount;
	private int custTennureYear;
	

}
