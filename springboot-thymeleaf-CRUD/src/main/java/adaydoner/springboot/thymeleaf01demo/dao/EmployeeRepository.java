package adaydoner.springboot.thymeleaf01demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import adaydoner.springboot.thymeleaf01demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	public List<Employee> findAllByOrderByLastNameAsc();
}