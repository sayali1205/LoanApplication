package com.loan.achintya.data.service;

import org.springframework.http.ResponseEntity;

import com.loan.achintya.data.model.Enquiry;

public interface EnquiryService {

public	ResponseEntity<Enquiry> updateEnquiry(Enquiry enquiry);

}
