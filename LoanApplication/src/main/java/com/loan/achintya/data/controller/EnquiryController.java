package com.loan.achintya.data.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@CrossOrigin(origins="*")
public class EnquiryController {

	
	@Autowired
	EnquiryService enquiryService;

	
	@Value("${spring.mail.username}")
	String fromEmail;

	@PutMapping("/updateEnquiry/{custId}")

	public ResponseEntity<Enquiry> updateEnquiry(@PathVariable("custId") int custId, @RequestBody Enquiry enquiry)

	{
		enquiry.setCustId(custId);
        Random rm=new Random();
		
		int minScore=300;
		int MaxScore=900;
		
		int cibilScore=rm.nextInt(MaxScore-minScore+1)+minScore;
		enquiry.setCibilScore(cibilScore);
		Enquiry enq=enquiryService.RequestCibil(enquiry);

		return new ResponseEntity<Enquiry>(enquiryService.updateEnquiry(enquiry), HttpStatus.OK);

	}

	@Value("${spring.mail.username}")
	String fromEmail;
	



	@PostMapping("/saveEnquiry")
	public ResponseEntity<Enquiry> createEnquiry(@RequestBody Enquiry enquiry) {
		
		enquiry.setCibilScore(0);
		Enquiry enq=enquiryService.RequestCibil(enquiry);

		return new ResponseEntity<Enquiry>(enq, HttpStatus.CREATED);

		
	}
	
	@PostMapping("/checkCibil")
	public ResponseEntity<Enquiry> checkCibil(@RequestBody Enquiry enquiry) {
		
		Random rm=new Random();
		
		int minScore=300;
		int MaxScore=900;
		
		int cibilScore=rm.nextInt(MaxScore-minScore+1)+minScore;
		enquiry.setCibilScore(cibilScore);
		Enquiry enq=enquiryService.RequestCibil(enquiry);
		return new ResponseEntity<Enquiry>(enq, HttpStatus.CREATED);
	}

	@PutMapping("/updateEnquiry/{custId}")

	public ResponseEntity<Enquiry> updateEnquiry(@PathVariable("custId") int custId, @RequestBody Enquiry enquiry)

	{
		enquiry.setCustId(custId);
       Random rm=new Random();
		
		int minScore=300;
		int MaxScore=900;
		
		int cibilScore=rm.nextInt(MaxScore-minScore+1)+minScore;
		enquiry.setCibilScore(cibilScore);
		Enquiry enq=enquiryService.RequestCibil(enquiry);

		return new ResponseEntity<Enquiry>(enquiryService.updateEnquiry(enquiry), HttpStatus.OK);

	}
	
	@GetMapping("/getAllEnquiry")
	public List<Enquiry> getAllEnquiry() {
		
		return enquiryService.getAllEnqury();
	}
	

	@PostMapping("/sendSuccessMail")
	public String sendMail(@RequestBody Enquiry e,String fromEmail) {
		
		enquiryService.sendMail(e,fromEmail);
		return "success mail send";
	}
	
	@PostMapping("/sendRejectMail")
public String sendRejectMail(@RequestBody Enquiry e,String fromEmail) {
		
		enquiryService.sendRejectMail(e,fromEmail);
		return "reject mail send";
	}
	


	@PostMapping("/sendRejectMail")
	public String sendRejectMail(@RequestBody Enquiry e, String fromEmail)
	{
		enquiryService.sendRejectMail(e,fromEmail);
		return "Reject Mail Send";
	}
	
	@PostMapping("/sendSuccessMail")
	public String sendMail(@RequestBody Enquiry e,String fromEmail) {
		
		enquiryService.sendMail(e,fromEmail);
		return "success mail send";
	}
	
	@PostMapping("/checkCibil")
	public ResponseEntity<Enquiry> checkCibil(@RequestBody Enquiry enquiry) {
		
		Random rm=new Random();
		
		int minScore=300;
		int MaxScore=900;
		
		int cibilScore=rm.nextInt(MaxScore-minScore+1)+minScore;
		enquiry.setCibilScore(cibilScore);
		Enquiry enq=enquiryService.RequestCibil(enquiry);
		return new ResponseEntity<Enquiry>(enq, HttpStatus.CREATED);
	}
	
	

	
	
}
