package adaydoner.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adaydoner.demo.aop.dao.AccountDAO;
import adaydoner.demo.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		Account myAccount = new Account();
		myAccount.setName("Ali");
		myAccount.seteMail("alidoganaydoner@gmail.com");
		System.out.println("\n\nCalling addAccount() method from AccountDAO");
		theAccountDAO.addAccount(myAccount,true);
/*		System.out.println("\n\nCalling doWork() method from AccountDAO");
		theAccountDAO.doWork();*/
		
		/*System.out.println("\n\nCalling getters and setters methods from AccountDAO");
		theAccountDAO.setName("Ali");
		theAccountDAO.getName();
		theAccountDAO.setAccountNumber("12345");
		theAccountDAO.getAccountNumber();
		
		System.out.println("\n\nCalling addMembership() method from MembershipDAO");
		theMembershipDAO.addMembership();*/
				
		//close the context
		context.close();
	}
}
