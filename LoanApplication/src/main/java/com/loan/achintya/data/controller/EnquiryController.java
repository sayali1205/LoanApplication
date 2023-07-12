package com.loan.achintya.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.loan.achintya.data.service.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	EnquiryService enquiryService;
}
