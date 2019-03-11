package springdemoannotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PracticeActivityFortuneService implements FortuneService {

	@Value("${foo.fortune}")
	public String[] fortunes;
	
	@Override
	public String getFortune() {
		return fortunes[(int)(Math.random() * fortunes.length)];
	}

}
