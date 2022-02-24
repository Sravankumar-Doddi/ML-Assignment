package com.bhavna.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bhavna.soap.loaneligibility.EmpResponce;
import com.bhavna.soap.loaneligibility.EmployeeRequest;
import com.bhavna.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityEndPoint {
	
	private static final String NAMESPACE = "http://www.bhavna.com/soap/loaneligibility";
	
	@Autowired
	private LoanEligibilityService service;
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "EmployeeRequest")
	@ResponsePayload
	public EmpResponce getLoanStatus(@RequestPayload EmployeeRequest request) {
		return service.loanEligibility(request);
	}
	
	
}
