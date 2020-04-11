package adaydoner.springboot.demo.springboot01.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootDemoRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	// new endpoint for field injection from properties file
	@GetMapping("/teaminfo")
	public String getTeamInfo(){
		return "Coach :" + coachName + " ,Team :" + teamName;
	}

	@GetMapping("/")
	public String sayHello(){
		
		return "Hello World";
	}
	
	@GetMapping("/testDevTools")
	public String testDevTools(){
		return "See this without restart app";
	}
}
