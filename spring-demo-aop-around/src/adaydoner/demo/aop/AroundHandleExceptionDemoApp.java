package adaydoner.demo.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adaydoner.demo.aop.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		boolean tripWire = true;
		System.out.println("Main Program : AroundHandleExceptionDemoApp");
		System.out.println("\n\nCalling getFortune() method at TrafficFortuneService.class");
		String data = theFortuneService.getFortune(tripWire);
		
		System.out.println("\n\nFortune is : " + data);
		System.out.println("\n\nDone..");
		
		
		// close the context
		context.close();

	}
}
