package springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LifeCoach implements Coach {
	
	@Autowired
	@Qualifier("RESTFortuneService")
	public FortuneService fortune;

	@Override
	public String getDailyWorkout() {
		return "think positively";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getFortune();
	}

}
