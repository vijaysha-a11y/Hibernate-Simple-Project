package com.tcs.hibernate_simple_project_crud_operation.controller;

import java.time.LocalDate;

import com.tcs.hibernate_simple_project_crud_operation.dao.EmployeeDao;
import com.tcs.hibernate_simple_project_crud_operation.entity.Employee;

public class InsertEmployeeController {

	public static void main(String[] args) {
		
		Employee employee = Employee.builder()
				.id(32256)
				.name("Dharmendra")
				.email("dharmendra@gmail.com")
				.phone(9856009765l)
				.doj(LocalDate.parse("2023-10-12"))
				.build();
		
		new EmployeeDao().saveEmployeeDao(employee);
	}
}
