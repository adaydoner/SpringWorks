package adaydoner.springboot.springboot05crudapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adaydoner.springboot.springboot05crudapi.dao.EmployeeDAO;
import adaydoner.springboot.springboot05crudapi.dao.EmployeeDAOJpaRepository;
import adaydoner.springboot.springboot05crudapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//1. version of dao layer technique , using EntityManager , leverage of Hibernate or JPA API's
	/*private EmployeeDAO employeeDAO;
	
	
	//you can change this bean with another dao implementation
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOHibernateImpl")EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}*/
	
	
	// 2. version of dao layer technique , using Spring Data JPA	
	private EmployeeDAOJpaRepository employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAOJpaRepository employeeRepository) {
		employeeDAO = employeeRepository;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	
	@Override
	@Transactional
	public Employee findById(int theId) {
		// 1. version of this method based on our dao technique
		/*return employeeDAO.findById(theId);*/
		
		//2. version
		Optional<Employee> result = employeeDAO.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent()){
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Didn't find employee id - " + theId);
		}
		return theEmployee;
		
	}
	
	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);

	}
	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);

	}

}
