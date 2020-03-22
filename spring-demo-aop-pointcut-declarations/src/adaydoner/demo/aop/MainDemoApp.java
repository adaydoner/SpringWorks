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
		/*System.out.println("Calling addAccount() method from AccountDAO");
		theAccountDAO.addAccount(new Account(),true);
		System.out.println("\n\nCalling doWork() method from AccountDAO");
		theAccountDAO.doWork();
		
		System.out.println("\n\nCalling addAccount() method from MembershipDAO");
		theMembershipDAO.addAccount();
		
		System.out.println("\n\nCalling addMembership() method from MembershipDAO");
		theMembershipDAO.addMembership();*/
		
		System.out.println("\n\n\n======>>>Trying advice with combined pointcut expression..");
		System.out.println("Calling setName() and getName() method and wait for combiningPointcutsExample() not work..");
		theAccountDAO.setName("Ali");
		System.out.println(theAccountDAO.getName());
		System.out.println("\n\n\nCalling addAccount() method from AccountDAO and wait for combiningPointcutsExample() work..");
		theAccountDAO.addAccount(new Account(), true);
		
		//close the context
		context.close();
	}
}
