package com.loan.achintya.data.serviceImpl;

import java.util.List;

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
	
		if(enquiry.getCibilScore() >= 750)
		{
			enquiry.setEnquiryStatus("CibilScore_OK");
			
		}
		else
		{
			enquiry.setEnquiryStatus("CIBIL_REJECT");
		}
		return enquiryRepository.save(enquiry);
	}

	@Override
	public Enquiry updateEnquiry(Enquiry enquiry) 
	{
		return enquiryRepository.save(enquiry);
	}

	@Override
	public List<Enquiry> getAllEnqury() {
		
		return enquiryRepository.findAll();
	}

	
	
}
