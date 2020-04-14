package adaydoner.springboot.springboot06springdatarest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import adaydoner.springboot.springboot06springdatarest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

}











