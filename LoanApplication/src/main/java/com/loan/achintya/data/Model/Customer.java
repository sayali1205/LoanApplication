package com.loan.achintya.data.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
    private String custProfeshion;
    @OneToOne(cascade = CascadeType.ALL)
    private DocumentDetails docData;
              
}
