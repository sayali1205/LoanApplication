package com.loan.achintya.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.achintya.data.model.Enquiry;
import com.loan.achintya.data.service.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	EnquiryService enquiryService;
	
	@PostMapping("/saveEnquiry")
	public ResponseEntity<Enquiry> createEnquiry(@RequestBody Enquiry enquiry) 
	{
		return new ResponseEntity<Enquiry>(enquiryService.saveEnquiry(enquiry), HttpStatus.OK);
	}
}
