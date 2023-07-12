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
public class DocumentDetails {

<<<<<<< HEAD

=======
	@Id
	private int docId;
>>>>>>> branch 'main' of https://github.com/sayali1205/LoanApplication.git
	private byte[] pancard;
	private byte[] adharCard;
	private byte[] form16;
	private byte[] itr;
	
}
