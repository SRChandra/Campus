package com.cg.mycampus.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cg.mycampus.Bean.Employee;
import com.cg.mycampus.Bean.Transaction;
import com.cg.mycampus.Bean.Vendor;

@Path("/transaction")
public class TransactionImpl {
	
	private static Map<Long, Transaction> listOfTransactions = new HashMap<>();

	public boolean addTransaction(Transaction transaction) {
		try {
			
			long length = listOfTransactions.size();
			listOfTransactions.put(length+1, transaction);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	}
	
	public static ArrayList<Transaction> getTransactionsForEmployee(Employee employee){
		System.out.println("employee id" + employee.getId());
		ArrayList<Transaction> listOfEmployeeTransactions = new ArrayList<Transaction>();
		for (Entry<Long, Transaction> entry : listOfTransactions.entrySet()) {
			System.out.println("entry.getValue().getEmployeeid()" + entry.getValue().getEmployeeid());
			if(entry.getValue().getVendorid() == (employee.getId())) {
				System.out.println("equal" + employee);
				listOfEmployeeTransactions.add(entry.getValue());
			}
		}		
		return listOfEmployeeTransactions;
	}
	
	@GET
	@Path("/{vendorid}")
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<Transaction> getTransactionsForEmployee(@PathParam("vendorid") Long vendorid){
		System.out.println("employee id" + vendorid);
		Employee employee = RegistrationImpl.listOfEmployees.get(vendorid);
		if(employee == null) {
			return null;
		}
		ArrayList<Transaction> listOfEmployeeTransactions = new ArrayList<Transaction>();
		for (Entry<Long, Transaction> entry : listOfTransactions.entrySet()) {
			System.out.println("entry.getValue().getEmployeeid()" + entry.getValue().getEmployeeid());
			if(entry.getValue().getVendorid() == (employee.getId())) {
				System.out.println("equal" + employee);
				listOfEmployeeTransactions.add(entry.getValue());
			}
		}		
		return listOfEmployeeTransactions;
	}
	
	
	public List<Transaction> getTransactionsForVendor(Vendor vendor){
		List<Transaction> listOfVendorTransactions = new ArrayList<Transaction>();
		for (Entry<Long, Transaction> entry : listOfTransactions.entrySet()) {
			if(entry.getValue().getVendorid() == (vendor.getId())) {
				listOfVendorTransactions.add(entry.getValue());
			}
		}	
		return listOfVendorTransactions;
	}
}
