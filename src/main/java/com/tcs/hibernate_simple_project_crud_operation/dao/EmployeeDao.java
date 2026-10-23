package com.tcs.hibernate_simple_project_crud_operation.dao;

import java.time.LocalDate;
import java.util.List;

import com.tcs.hibernate_simple_project_crud_operation.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class EmployeeDao {

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

	public Employee saveEmployeeDao(Employee employee) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			et.begin();
			em.persist(employee);
			et.commit();	

			return employee;
		} catch (Exception e) {

			if (et.isActive()) {
				et.rollback();
			}

			e.printStackTrace();
			return null;
		} finally {

			if (em.isOpen()) {
				em.close();
			}
		}
	}

	/**
	 * 
	 * @param employeeId
	 * @return Employee object
	 * @throws IllegalArgumentException if whatever object you have passed in first
	 *                                  parameter thats not an entity class
	 * 
	 */
	public Employee getEmployeeByIdDao(int employeeId) {
		EntityManager em = emf.createEntityManager();
		try {
			Employee employee = em.find(Employee.class, employeeId);
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public boolean deleteEmployeeById(int employeeId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			Employee employee = em.find(Employee.class, employeeId);

			if (employee != null) {

				et.begin();

				em.remove(employee);

				et.commit();

				return true;
			}

			return false;
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public Employee updateEmployeeDojByEmployeeId(int employeeId, LocalDate doj) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			Employee employee = em.find(Employee.class, employeeId);

			if (employee != null) {

				employee.setDoj(doj);

				et.begin();

				em.merge(employee);

				et.commit();

				return employee;
			}

			return null;
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public List<Employee> getAllEmployeeDao() {

		EntityManager em = emf.createEntityManager();

		try {

			TypedQuery<Employee> typedQuery = em.createQuery("From Employee", Employee.class);

			return typedQuery.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public Employee getEmployeeByEmailDao(String email) {

		EntityManager em = emf.createEntityManager();

		try {

			TypedQuery<Employee> typedQuery = em.createQuery("Select e From Employee e where e.email=?1",
					Employee.class);

			typedQuery.setParameter(1, email);

			try {
				Employee employee = typedQuery.getSingleResult();
				return employee;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public boolean deleteEmployeeByRegisterationDateDao(LocalDate registerDate) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

//			Query query = em.createNativeQuery("Delete from employee where registrationDate=?1");
			
			Query query = em.createQuery("Delete Employee e where e.registrationDate=?1");

			query.setParameter(1, registerDate);

			et.begin();
			int a = query.executeUpdate();
			et.commit();
			return a != 0 ? true : false;

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

}
