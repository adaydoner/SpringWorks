package springdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(springdemoannotations.SportConfig.class);
		
		SwimCoach tCoach = context.getBean("swimCoach",SwimCoach.class);

		System.out.println(tCoach.getDailyWorkout());
		System.out.println(tCoach.getDailyFortune());
		System.out.println(tCoach.getEmail());
		System.out.println(tCoach.getTeam());
		
		context.close();
		
	}
}
