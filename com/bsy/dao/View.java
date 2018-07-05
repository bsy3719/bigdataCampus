package com.bsy.dao;
import java.util.ArrayList;
import com.bsy.model.Customer;

public class View {
	
	public void custView(ArrayList<Customer> custList, int index){
		
		Customer cust = custList.get(index);
		System.out.println("==========CUSTOMER INFO================");
		System.out.println("이름 : " + cust.getName());
		System.out.println("성별 : " + cust.getGender());
		System.out.println("이메일 : " + cust.getEmail());
		System.out.println("출생년도 : " + cust.getBirthYear());
		System.out.println("=======================================");
		
	}
	
	public void custView(ArrayList<Customer> custList){
		
		System.out.println("==========CUSTOMER INFO================");
		for(int i=0; i< custList.size(); i++) {
		
			Customer cust = custList.get(i);
			System.out.printf("%d 번째 고객",i);
			System.out.print("  이름 :" + cust.getName()+" ");
			System.out.print("성별 :" + cust.getGender()+" ");
			System.out.print("이메일 :" + cust.getEmail()+" ");
			System.out.println("출생년도 :" + cust.getBirthYear());
		
		}
		System.out.println("=======================================");
		
	}

}
