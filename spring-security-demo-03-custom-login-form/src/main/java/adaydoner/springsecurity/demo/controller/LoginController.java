package adaydoner.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	//mapping for adaydoner.springsecurity.demo.config.DemoSecurityConfig configuration configure(HttpSecurity http) method
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "plain-login";
		
		
	}

}
