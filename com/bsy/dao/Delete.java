package com.bsy.dao;
import java.util.ArrayList;
import com.bsy.model.Customer;

public class Delete {
	
	public ArrayList<Customer> custDelete(ArrayList<Customer> custList, int index){

		custList.remove(index);
		
		return custList;
	}

}
