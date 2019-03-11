package springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach tCoach = context.getBean("tennisCoach",Coach.class);

		System.out.println(tCoach.getDailyWorkout());
		System.out.println(tCoach.getDailyFortune());
		
		context.close();
		
	}
}
