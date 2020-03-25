package adaydoner.demo.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adaydoner.demo.aop.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = theAccountDAO.findAccounts(tripWire);
		} 
		catch (Exception exc) {
			System.out.println("\n\nMain Program caught exception : " + exc);
		}
		
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("---");
		System.out.println(accounts);

		// close the context
		context.close();

	}
}
