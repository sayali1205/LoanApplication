package com.loan.achintya.data.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int docId;

	private byte[] pancard;
	private byte[] adharCard;
	private byte[] form16;
	private byte[] itr;
	
}
