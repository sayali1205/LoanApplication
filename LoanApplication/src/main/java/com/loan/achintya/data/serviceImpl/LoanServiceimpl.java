package com.loan.achintya.data.serviceImpl;

import org.springframework.stereotype.Service;

import com.loan.achintya.data.model.EMI;

import com.loan.achintya.data.service.LoanService;
@Service
public class LoanServiceimpl implements LoanService {

	@Override
	public EMI emiCalculate(EMI emi) {
		double monthlyInterestRate=emi.getAnnualInterestRate()/12/100;
		  double numerator = emi.getPrincipal() *( monthlyInterestRate) * Math.pow(1 + monthlyInterestRate, emi.getTenureInMonths());
	        double denominator = Math.pow(1 + monthlyInterestRate, emi.getTenureInMonths()) - 1;
		
		
	       double monthlyEMI=numerator / denominator;
	       emi.setEmi(monthlyEMI);
	        return emi;
		
	}

	

}
