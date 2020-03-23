package adaydoner.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount(){
		System.out.println(getClass() + " : addAccount()");
	}
	
	public boolean addMembership(){
		System.out.println(getClass() + " : addMembership()");
		return true;
	}

}
