package adaydoner.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component(value="accountDAO")
public class AccountDAO {
	
	
	public void addAccount(){
		System.out.println(getClass() + "/addAccount() method for DB works...");
	}
}
