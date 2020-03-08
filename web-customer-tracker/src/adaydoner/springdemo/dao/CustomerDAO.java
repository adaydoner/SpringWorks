package adaydoner.springdemo.dao;

import java.util.List;

import adaydoner.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
