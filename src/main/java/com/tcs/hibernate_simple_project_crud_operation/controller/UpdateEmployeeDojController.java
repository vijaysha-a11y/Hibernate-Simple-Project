package com.tcs.hibernate_simple_project_crud_operation.controller;

import java.time.LocalDate;

import com.tcs.hibernate_simple_project_crud_operation.dao.EmployeeDao;
import com.tcs.hibernate_simple_project_crud_operation.entity.Employee;

public class UpdateEmployeeDojController {

	public static void main(String[] args) {
		
		Employee employee=new EmployeeDao().updateEmployeeDojByEmployeeId(3456, LocalDate.parse("2003-10-23"));
		
		if(employee!=null) {
			System.out.println("your new doj is updated "+employee.getDoj());
		}
	}
}
