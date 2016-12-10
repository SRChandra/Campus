package com.cg.mycampus.Impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.cg.mycampus.Bean.Employee;
import com.cg.mycampus.Bean.Vendor;

public class RegistrationImpl {
	public static  String PINString=null;
	public static Map<Long, Employee> listOfEmployees = new HashMap<>();
	
	private static Map<Long, Vendor> listOfVendors = new HashMap<>();
	
	public boolean addEmployee(Employee employee) {
		try {
			/*generatePin();
			employee.setPin(PINString);*/
			listOfEmployees.put(employee.getId(), employee);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}		
	}
	
	public Employee getEmployee(Long employeeid) {
		try {			
			return listOfEmployees.get(employeeid);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}		
	}
	
	public static boolean validateEmployeePin(long empid, String pin){
		try {
			Employee employee = listOfEmployees.get(empid);
			if(employee == null)
				return false;
			if(employee.getPin().equals(pin))
				return true;
			else 
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	}
	
	public String generatePin() {

		// generate a 4 digit integer 1000 <10000
		int randomPIN = (int) (Math.random() * 9000) + 1000;

		// Store integer in a string
		PINString = String.valueOf(randomPIN);
		System.out.println("generated pin" + PINString);
		return PINString;
	}

	public boolean addVendor(Vendor vendor) {
		try {
			listOfVendors.put(vendor.getId(), vendor);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}		
	}
	
/*	public static boolean validateVendorId(long vendorId, String pin){
		try {
			Vendor vendor = listOfVendors.get(vendorId);
			if(vendor == null)
				return false;
			else If (vendor.getUin())
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	}*/
	
	public boolean changePin(Employee employee, String oldPin, String newPin) {
		try {
			if(employee.getPin().equalsIgnoreCase(oldPin)){
				Employee mapEmployee = listOfEmployees.get(employee.getId());
				mapEmployee.setPin(newPin);
				listOfEmployees.put(employee.getId(), mapEmployee);
				return true;
			} else {
				System.out.println("old pin does not match");
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	}

}
