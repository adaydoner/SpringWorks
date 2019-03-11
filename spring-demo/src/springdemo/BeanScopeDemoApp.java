package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//load the configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		//retrieve the bean from config file
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		System.out.println(theCoach == alphaCoach);
		System.out.println("theCoach object's address : " + theCoach);
		System.out.println("alphaCoach object's address : " + alphaCoach);
		
		//close the context
		context.close();

	}

}
