package com.loan.achintya.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.achintya.data.model.Enquiry;
import com.loan.achintya.data.service.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	EnquiryService enquiryService;
	
	@PostMapping("/updateUser/custId")
	public ResponseEntity<Enquiry> updateEnquiry(@RequestBody Enquiry enquiry,@PathVariable("custId") int custId)
	{
		return enquiryService.updateEnquiry(enquiry);
	}
}
