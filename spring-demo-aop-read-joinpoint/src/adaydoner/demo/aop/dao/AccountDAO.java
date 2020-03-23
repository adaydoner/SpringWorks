package adaydoner.demo.aop.dao;

import org.springframework.stereotype.Component;

import adaydoner.demo.aop.Account;

@Component(value="accountDAO")
public class AccountDAO {
	private String name;
	private String accountNumber;
	
	
	public void addAccount(Account theAccount, boolean vipFlag){
		System.out.println(getClass() + " : addAccount()");
	}
	
	public void doWork(){
		System.out.println(getClass() + " : doWork()");
	}

	/**
	 * geters and setters
	 */
	
	public String getName() {
		System.out.println(getClass() + " getName() worked..");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setName() worked..");
		this.name = name;
	}

	public String getAccountNumber() {
		System.out.println(getClass() + " getAccountNumber() worked..");
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		System.out.println(getClass() + " setAccountNumber() worked..");
		this.accountNumber = accountNumber;
	}
	
	
}
