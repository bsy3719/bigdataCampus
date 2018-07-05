package com.bsy.dao;
import java.util.ArrayList;
import java.util.Scanner;
import com.bsy.model.Customer;

public class Update {
	
	public ArrayList<Customer> custUpdate(ArrayList<Customer> custList, Scanner scan, int index){
		
		Customer cust = custList.get(index);
		System.out.println("---------UPDATE CUSTOMER INFO----------");
		System.out.print("이름(" + cust.getName() + ") :");
		cust.setName(scan.next());

		System.out.print("성별(" + cust.getGender() + ") :");
		cust.setGender(scan.next().charAt(0));

		System.out.print("이메일(" + cust.getEmail() + ") :");
		
		cust.setEmail(scan.next());

		System.out.print("출생년도(" + cust.getBirthYear() + ") :");
		cust.setBirthYear(scan.nextInt());	
		
		return custList;
	}

}
