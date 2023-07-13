package com.loan.achintya.data.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.loan.achintya.data.model.Enquiry;

public interface EnquiryService {

	public Enquiry saveEnquiry(Enquiry enquiry);

	public Enquiry updateEnquiry(Enquiry enquiry);

	public List<Enquiry> getAllEnqury();


}
