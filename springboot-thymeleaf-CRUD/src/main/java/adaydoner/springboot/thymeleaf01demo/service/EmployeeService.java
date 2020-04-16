package adaydoner.springboot.thymeleaf01demo.service;

import java.util.List;

import adaydoner.springboot.thymeleaf01demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
