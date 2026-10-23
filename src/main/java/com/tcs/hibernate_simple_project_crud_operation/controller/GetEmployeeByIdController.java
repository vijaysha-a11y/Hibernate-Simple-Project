package com.tcs.hibernate_simple_project_crud_operation.controller;

import com.tcs.hibernate_simple_project_crud_operation.dao.EmployeeDao;
import com.tcs.hibernate_simple_project_crud_operation.entity.Employee;

public class GetEmployeeByIdController {

	public static void main(String[] args) {
		
		Employee employee=new EmployeeDao().getEmployeeByIdDao(3456);
		
		if(employee!=null) {
			System.out.println(employee);
		}else {
			System.out.println("check your id or something went wrong...");
		}
	}
}
