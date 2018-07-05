package com.bsy.service;

import java.util.ArrayList;
import java.util.Scanner;
import com.bsy.model.Customer;
import com.bsy.dao.*;

public class CustomerService implements ICustomerService{
	
		private ArrayList<Customer> custList = new ArrayList<>();
		private int index = -1;
		private int count = 0;
		private Scanner scan = new Scanner(System.in);
		
		private View view = new View();
		private Insert insert = new Insert();
		private Update update = new Update();
		private Delete delete = new Delete();
		
		public void run() {

			while(true) {
				count = custList.size();
				System.out.printf("\n[INFO] 고객 수 : %d, 인덱스 : %d\n", count, index);
				System.out.println("메뉴를 입력하세요.");
				System.out.println("(I)nsert, (P)revious, (N)ext, " +
						"(C)urrent, (U)pdate, (D)elete, (Q)uit, (A)ll");
				System.out.print("메뉴 입력: ");
				String menu = scan.next();
				menu = menu.toLowerCase();	//입력한 문자열을 모두소문자로 변환
				switch(menu.charAt(0)) {
				case 'i':
					System.out.println("고객정보 입력을 시작합니다.");
					insert.custInsert(custList, scan);
					System.out.println("고객정보를 입력했습니다.");
					break;
				case 'p' :
					System.out.println("이전 데이터를 출력합니다.");
					if(index <= 0) {
						System.out.println("이전 데이터가 존재하지 않습니다.");
					}else {
						index--;
						view.custView(custList, index);
					}
					break;
				case 'n' :
					System.out.println("다음 데이터를 출력합니다.");
					if(index >= count-1) {
						System.out.println("다음 데이터가 존재하지 않습니다.");
					}else {
						index++;
						view.custView(custList, index);
					}
					break;
				case 'c' :
					System.out.println("현재 데이터를 출력합니다.");
					if( (index >= 0) && (index < count)) {
						view.custView(custList, index);
					}else {
						System.out.println("출력할 데이터가 선택되지 않았습니다.");
					}
					break;			
				case 'u' :
					System.out.println("데이터를 수정합니다.");
					if( (index >= 0) && (index < count)) {
						System.out.println(index + "번째 데이터를 수정합니다.");
						update.custUpdate(custList, scan, index);
					}else {
						System.out.println("수정할 데이터가 선택되지 않았습니다.");
					}
					break;
				case 'd' :
	            	if (count == 0){
	              		System.out.println("삭제할 데이터가 없습니다.");
	            	}
	            	else {
	            		System.out.println("데이터를 삭제하시겠습니까? (Y/N)");
	            		view.custView(custList, index);
	            		String menu2 = scan.next();
	            		menu2 = menu2.toLowerCase();
	            		if(menu2.charAt(0) == 'y') {
	            			if( (index >= -1) && (index < count)) {
	               				System.out.println(index + "번째 데이터를 삭제합니다.");
	               			delete.custDelete(custList, index);
							}
	            			else {
	               				System.out.println("삭제할 데이터가 선택되지 않았습니다.");
	               			}
	            		}
	            		else if (menu2.charAt(0) == 'n') {
	               			System.out.println("취소되었습니다.");
	            		}
	            	}
	            break;
		         
				case 'q' :
					System.out.println("프로그램을 종료합니다.");
					scan.close();	//Scanner 객체를 닫아준다.
					System.exit(0);	//프로그램을 종료시킨다.
					break;	
				case 'a' :
					System.out.println("전체 리스트를 보여줍니다.");
					view.custView(custList);
					break;	
				default : 
					System.out.println("메뉴를 잘 못 입력했습니다.");	
				}//end switch
			}//end while
		}//end main

}
