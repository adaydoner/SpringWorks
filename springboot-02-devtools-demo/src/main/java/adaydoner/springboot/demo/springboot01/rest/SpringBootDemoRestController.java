package adaydoner.springboot.demo.springboot01.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootDemoRestController {

	@GetMapping("/")
	public String sayHello(){
		
		return "Hello World";
	}
	
	@GetMapping("/testDevTools")
	public String testDevTools(){
		return "See this without restart app";
	}
}
