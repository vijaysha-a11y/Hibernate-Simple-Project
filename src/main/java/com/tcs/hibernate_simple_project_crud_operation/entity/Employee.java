package com.tcs.hibernate_simple_project_crud_operation.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
	
	@Id
	private int id;
	private String name;
	@Column(unique = true,length = 25,nullable = false)
	private String email;
	@Column(unique = true,length = 12,nullable = false)
	private long phone;
	private LocalDate doj;
	@CreationTimestamp
	private LocalDate registrationDate;
}
