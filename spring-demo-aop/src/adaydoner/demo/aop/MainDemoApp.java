package adaydoner.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adaydoner.demo.aop.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		
		//close the context
		context.close();
	}
}