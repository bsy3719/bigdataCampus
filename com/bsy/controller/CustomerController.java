package com.bsy.controller;
import com.bsy.service.ICustomerService;

public class CustomerController {
	
	ICustomerService custService;
	
	public void setCustomerService(ICustomerService custService) {
		this.custService = custService;
	}
	
	public void run() {
		custService.run();
	}
	
	

}
