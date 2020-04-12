package adaydoner.springboot.springboot05crudapi.service;

import java.util.List;

import adaydoner.springboot.springboot05crudapi.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
