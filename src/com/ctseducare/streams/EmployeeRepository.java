package com.ctseducare.streams;

import java.util.List;

public class EmployeeRepository {
	
	private List<Employee> employees = List.of(
			new Employee(1, "Fulano da Silva", 3500.0), 
		    new Employee(2, "Beltrano Gomes", 4100.0), 
		    new Employee(3, "Siclano Pereira", 1800.0),
		    new Employee(4, "Anequim Gonçalves", 2400.0),
		    new Employee(5, "Nama Pedrosa", 3200.0)
    );
	
	public Employee findById(Integer id) {
		Employee employee = null;
		for (Employee e : employees) {
			if (e.getId() == id) {
				employee = e;
				break;
			}
		}
		return employee;
	}

}
