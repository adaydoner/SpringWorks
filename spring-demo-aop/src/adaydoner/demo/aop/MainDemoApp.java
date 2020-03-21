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
		theAccountDAO.addAccount(new Account(),true);
		
		theMembershipDAO.addAccount();
		
		theMembershipDAO.addMembership();
		
		theAccountDAO.doWork();
		
		
		//close the context
		context.close();
	}
}
