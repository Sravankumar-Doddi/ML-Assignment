package com.bhavna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhavna.soap.loaneligibility.EmpResponce;
import com.bhavna.soap.loaneligibility.EmployeeRequest;

@Service
public class LoanEligibilityService {
	
	public EmpResponce loanEligibility(EmployeeRequest request) {
		EmpResponce empResponce = new EmpResponce();
		List<String> mismatch = empResponce.getCriteriaMismatch();
		
		if (!(request.getAge() >= 21 && request.getAge() <= 60)) {
			mismatch.add("Employee age should be in between 21 to 60");
		}
		
		if (!(request.getYearlyIncome() > 180000)) {
			mismatch.add("minimum income should be more than 180000");
		}
		
		if (!(request.getCibilScore() > 500)) {
			mismatch.add("Low CIBIL score please try after 3 months");
		}
		
		if (mismatch.size() > 0) {
			empResponce.setApprovedAmount(0);
		    empResponce.setIsEligible(false);	
		}
		else {
			empResponce.setApprovedAmount(1000000);
			empResponce.setIsEligible(true);
			mismatch.clear();
		}
		
		return empResponce;
	}

}
