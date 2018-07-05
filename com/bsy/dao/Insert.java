package com.bsy.dao;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.bsy.model.Customer;

public class Insert {
	
	public ArrayList<Customer> custInsert(ArrayList<Customer> custList, Scanner scan){
		
		String name = "";
		String genderString;
		char genderChar;
		String email = "";
		String birthYearString = "";
		int birthYearInt = 0;
		
		while(true) {
			System.out.print("이름 : ");	
			name = scan.next();
			if (!name.matches(".*[0-9].*")) {
				break;
			}else {
				System.out.println("양식에 맞지 않습니다. 다시 입력해주새요.");
			}
		}
		
		while(true) {
			System.out.print("성별(M/F) : ");	
			genderString = scan.next();
			//gender = scan.next().charAt(0);
			
			if (genderString.equals("M") || genderString.equals("F")) {
				genderChar = genderString.charAt(0);
				break;
			}else {
				System.out.println("양식에 맞지 않습니다. 다시 입력해주새요.");
			}
		}
		
		while(true) {
			System.out.print("이메일 : ");	
			email = scan.next();
			
			if (isValidEmail(email)) {
				break;
			}else {
				System.out.println("양식에 맞지 않습니다. 다시 입력해주새요.");
			}
		}
		
		while(true) {
			System.out.print("출생년도 : ");	
			birthYearString = scan.next();
			
			if (NumberChk(birthYearString)) {
				birthYearInt = Integer.parseInt(birthYearString);
				break;
			}else {
				System.out.println("양식에 맞지 않습니다. 다시 입력해주새요.");
			}
		}
		
		//입력받은 데이터로 고객 객체를 생성
		Customer cust = new Customer(name, genderChar, email, birthYearInt);

		//고객 객체를 ArrayList에 저장
		custList.add(cust);
		
		
		return custList;
		
	}
	
	private static boolean NumberChk(String str) {

		char charVal;

		if (str.equals("")) return false;

		for (int i=0; i<str.length(); i++) {
		charVal = str.charAt(i);
		if (charVal<48 || charVal>57) {
		return false;
			}
		}
		return true;
	}

	
	private boolean isValidEmail(String email) {
		  boolean err = false;
		  String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";   
		  Pattern p = Pattern.compile(regex);
		  Matcher m = p.matcher(email);
		  if(m.matches()) {
		   err = true; 
		  }
		  return err;
		 }

}
