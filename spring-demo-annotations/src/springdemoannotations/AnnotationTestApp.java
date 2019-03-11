package springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTestApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach testCoach = context.getBean("tennisCoach",Coach.class);
		
		
		System.out.println(testCoach.getDailyFortune());
		
		context.close();

	}

}
