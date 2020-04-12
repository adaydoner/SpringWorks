package adaydoner.springboot.springboot05crudapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import adaydoner.springboot.springboot05crudapi.entity.Employee;

//this interface doesn't associate with EmployeeDAOJpaImpl, this is a third technique of setting up a dao layer 
public interface EmployeeDAOJpaRepository extends JpaRepository<Employee, Integer> {

	/*
	 *this interface is no need any implementation code, all of its come from JpaRepository interface 
	 * we just give our entity class and primary key's type 
	 */
	
	/*
	 * to use this dao technique we need to update our serviceImpl.class 
	 * we would use this bean instead of DAO bean
	 */
}
