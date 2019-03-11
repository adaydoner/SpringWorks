package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach myCricketCoach = context.getBean("myCricketCoach",CricketCoach.class);
		
		//call methods on the bean
		System.out.println(myCricketCoach.getDailyWorkoutRoutine());
		System.out.println(myCricketCoach.getDailyFortune());
		System.out.println(myCricketCoach.getEmailAddress());
		System.out.println(myCricketCoach.getTeam());
		
		//close the context
		context.close();
	}

}
