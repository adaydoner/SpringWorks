package adaydoner.springboot.springboot05crudapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import adaydoner.springboot.springboot05crudapi.entity.Employee;
import adaydoner.springboot.springboot05crudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
		
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null){
			throw new RuntimeException("employee not found id - " + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){
		
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}

	
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		
		Employee tmpEmployee = employeeService.findById(employeeId);
		
		if(tmpEmployee == null){
			throw new RuntimeException("employee not found id - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "deleted id - " + employeeId;
		
	}
	
}
