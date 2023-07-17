package com.loan.achintya.data.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.achintya.data.model.Enquiry;
import com.loan.achintya.data.service.EnquiryService;

@RestController
@CrossOrigin("*")
public class EnquiryController {

	@Autowired
	EnquiryService enquiryService;

	@PutMapping("/updateEnquiry/{custId}")

	public ResponseEntity<Enquiry> updateEnquiry(@PathVariable("custId") int custId, @RequestBody Enquiry enquiry)

	{
		enquiry.setCustId(custId);

		return new ResponseEntity<Enquiry>(enquiryService.updateEnquiry(enquiry), HttpStatus.OK);

	}
	
	
	//Email send to Customer

	@PostMapping("/saveEnquiry")
	public ResponseEntity<Enquiry> createEnquiry(@RequestBody Enquiry enquiry) {
		
		Random rm=new Random();
		
		int minScore=300;
		int MaxScore=900;
		
		int cibilScore=rm.nextInt(MaxScore-minScore+1)+minScore;
		enquiry.setCibilScore(cibilScore);
		Enquiry enq=enquiryService.saveEnquiry(enquiry);
		return new ResponseEntity<Enquiry>(enq, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllEnquiry")
	public List<Enquiry> getAllEnquiry() {
		
		return enquiryService.getAllEnqury();
	}
	
	
	
}
