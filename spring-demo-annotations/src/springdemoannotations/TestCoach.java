package springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestCoach implements Coach {
	
	@Autowired
	@Qualifier("practiceActivityFortuneService")
	public FortuneService fortune;

	@Override
	public String getDailyWorkout() {
		return "this is test coach";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getFortune();
	}

}
