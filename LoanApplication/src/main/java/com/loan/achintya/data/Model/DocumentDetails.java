
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
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int docId;

	@Lob
	private byte[] pancard;
	@Lob
	private byte[] adharCard;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] form16;
	@Lob
	private byte[] itr;
	
}
