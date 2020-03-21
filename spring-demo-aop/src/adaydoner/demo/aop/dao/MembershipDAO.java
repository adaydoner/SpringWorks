package adaydoner.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount(){
		System.out.println(getClass() + " : possible DB work for MembershipDAO.addAccount()");
	}
	
	public boolean addMembership(){
		System.out.println(getClass() + " : possible DB work for MembershipDAO.addMembership()");
		return true;
	}

}
