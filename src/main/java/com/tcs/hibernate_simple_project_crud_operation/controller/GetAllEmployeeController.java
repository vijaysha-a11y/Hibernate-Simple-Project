package com.tcs.hibernate_simple_project_crud_operation.controller;

import java.time.LocalDate;
import java.util.List;

import com.tcs.hibernate_simple_project_crud_operation.dao.EmployeeDao;
import com.tcs.hibernate_simple_project_crud_operation.entity.Employee;

public class GetAllEmployeeController {

	public static void main(String[] args) {
		
//		List<Employee> employees=new EmployeeDao().getAllEmployeeDao();
//		
//		if(employees!=null&&!employees.isEmpty()) {
			
//			employees.forEach(System.out::println);
//		}
		
		/*
		 * Employee employee=new
		 * EmployeeDao().getEmployeeByEmailDao("dharmendra@gmail.com");
		 * 
		 * if(employee!=null) { System.out.println(employee); }else {
		 * System.out.println("given email is not found"); }
		 */
		
		boolean b=new EmployeeDao().deleteEmployeeByRegisterationDateDao(LocalDate.parse("2026-10-05"));
	
		String msg = b?"deleted":"something went wrong or check with your registerdate";
		
		System.out.println(msg);
	}
}
