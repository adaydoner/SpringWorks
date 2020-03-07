package adaydoner.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import adaydoner.springdemo.dao.CustomerDAO;
import adaydoner.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	/* it automatically finds class that implements CustomerDAO and inject that*/
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers (Model theModel){
		
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}

}
