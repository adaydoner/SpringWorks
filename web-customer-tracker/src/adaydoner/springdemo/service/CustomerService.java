package adaydoner.springdemo.service;

import java.util.List;

import adaydoner.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
