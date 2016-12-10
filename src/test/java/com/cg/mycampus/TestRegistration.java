package com.cg.mycampus;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import com.cg.mycampus.Bean.Employee;

public class TestRegistration {
	
	@Test
	public void TestEmployeeRegistration(){
		Employee employee = Mockito.mock(Employee.class);
//		employee.setId((long) 1234);
//		employee.setName("abc");
//		employee.setEmail("abc@abc.org");
//		employee.setMobile("989339");
		Mockito.verify(employee);
		
	}
	

}
