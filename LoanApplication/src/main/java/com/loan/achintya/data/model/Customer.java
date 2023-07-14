package com.loan.achintya.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String custFirstName;
    private String custLastName;
    private String custGender;
    private long custContactNo;
    private String custEmailId;
    private String custProfession;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    private DocumentDetails docData;
//    
//    @OneToOne(cascade  = CascadeType.ALL)
//    private LoanDetails loanDetails;
//    
//    @OneToOne(cascade = CascadeType.ALL)
//      private Address address; 
//    
//    @OneToMany(cascade = CascadeType.ALL,targetEntity = Transaction.class)
//    private Transaction transaction;
//    
//    @OneToOne(cascade = CascadeType.ALL)
//    private BankDetails bankDetails;
//    
//    @OneToOne(cascade = CascadeType.ALL)
//    private SanctionDetails sactiondetails;
}
