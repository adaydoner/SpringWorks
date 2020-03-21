package adaydoner.demo.aop.dao;

import org.springframework.stereotype.Component;

import adaydoner.demo.aop.Account;

@Component(value="accountDAO")
public class AccountDAO {
	
	
	public void addAccount(Account theAccount, boolean vipFlag){
		System.out.println(getClass() + " : possible DB works for AccountDAO");
	}
	
	public void doWork(){
		System.out.println(getClass() + " : doWork()");
	}
}
