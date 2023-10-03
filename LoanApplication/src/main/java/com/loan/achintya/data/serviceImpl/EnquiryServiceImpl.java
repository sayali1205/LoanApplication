package com.loan.achintya.data.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.loan.achintya.data.model.Enquiry;
import com.loan.achintya.data.repository.EnquiryRepository;
import com.loan.achintya.data.service.EnquiryService;


@Service
public class EnquiryServiceImpl implements EnquiryService {
	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	JavaMailSender ms;


	@Override
	public Enquiry updateEnquiry(Enquiry enquiry) 
	{
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
	public List<Enquiry> getAllEnqury() {
		
		return enquiryRepository.findAll();
	}

	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) {
	
		if(enquiry.getCibilScore()==0) {
			enquiry.setEnquiryStatus("Just_Created");
		}
		
		return enquiryRepository.save(enquiry);
	}

	@Override
	public Enquiry RequestCibil(Enquiry enquiry) {
		if(enquiry.getCibilScore() >= 750)
		{
			enquiry.setEnquiryStatus("CibilScore_OK");
			
		}
		else if(enquiry.getCibilScore()==0) {
			enquiry.setEnquiryStatus("Just_Created");
		}
		else
		{
			enquiry.setEnquiryStatus("CIBIL_REJECT");
		}
		return enquiryRepository.save(enquiry);
	}

	@Override
	public void sendMail(Enquiry e, String fromEmail) {
		
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(e.getCustEmailId());
		msg.setFrom(fromEmail);
		msg.setSubject("Loan Apply Success");
		msg.setText("Your loan application successfully passed");
		ms.send(msg);
		
			}

	@Override
	public void sendRejectMail(Enquiry e, String fromEmail) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(e.getCustEmailId());
		msg.setFrom(fromEmail);
		msg.setSubject("Loan Apply Rejected");
		msg.setText("Your loan application is rejected");
		ms.send(msg);
		
	}

	@Override
	public List<Enquiry> getAllJustCreatedEnquiry() {
		enquiryRepository.findAll();
		List<Enquiry> l= enquiryRepository.findAll();
		Iterator<Enquiry> itr=l.iterator();
		List<Enquiry> list=new ArrayList<>();
		while(itr.hasNext()) {
			Enquiry enq=itr.next();
			
			if(enq.getEnquiryStatus().equalsIgnoreCase("Just_Created")) { 
				
				list.add(enq);
				
				}
		}

		System.out.println(l.size());
		
		System.out.println(list.size());
			
			return list;
	}

	@Override
	public void deleteById(int custId) {
		enquiryRepository.deleteById(custId);
		
		
	}
	
}

	

