package adaydoner.demo.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adaydoner.demo.aop.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = theAccountDAO.findAccounts();
		
		
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		for (Account account : accounts) {
			System.out.println(account);
		}
		
		//close the context
		context.close();
	}
}
