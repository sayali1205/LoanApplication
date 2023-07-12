package com.loan.achintya.data.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.loan.achintya.data.model.Enquiry;
import com.loan.achintya.data.repository.EnquiryRepository;
import com.loan.achintya.data.service.EnquiryService;


@Service
public class EnquiryServiceImpl implements EnquiryService {
	@Autowired
	EnquiryRepository enquiryRepository;

	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) {
	
		return enquiryRepository.save(enquiry);
	}

	
}
