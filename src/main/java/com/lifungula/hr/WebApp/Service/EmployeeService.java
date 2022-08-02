package com.lifungula.hr.WebApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifungula.hr.WebApp.Model.Employee;
import com.lifungula.hr.WebApp.Repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {

	@Autowired
	private EmployeeProxy employeeProxy;

	public Employee getEmployee(final int id) {
		return employeeProxy.getEmployee(id);
	}

	public Iterable<Employee> getEmployees() {
		return employeeProxy.getEmployees();
	}

	public void deleteEmployee(final int id) {
		employeeProxy.deleteEmployee(id);
	}

	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee;

		// Règle de gestion : Le nom de famille doit être mis en majuscule.
		employee.setLastName(employee.getLastName().toUpperCase());

		if(employee.getId() == null) {
			// Si l'id est nul, alors c'est un nouvel employé.
			savedEmployee = employeeProxy.createEmployee(employee);
		} else {
			savedEmployee = employeeProxy.updateEmployee(employee);
		}

		return savedEmployee;
	}
}
