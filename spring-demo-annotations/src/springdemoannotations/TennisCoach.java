package springdemoannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	public FortuneService fortuneService;
	
	public TennisCoach(){
		
	}
	
	/*@Autowired
	public TennisCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
/*	
	@PostConstruct
	public void doMyStartupStaff(){
		System.out.println("inside tennis coach init method");
	}
	
	@PreDestroy
	public void doMyCloseupStaff(){
		System.out.println("inside tennis coach destroy method");
	}*/

	
	/*@Autowired
	public void anyMethodName(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	

}
