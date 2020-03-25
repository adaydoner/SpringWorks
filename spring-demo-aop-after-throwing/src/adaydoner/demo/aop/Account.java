package adaydoner.demo.aop;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private String name;
	private String eMail;
	
	public Account(){
		
	}
	
	
	public Account(String name, String eMail) {
		this.name = name;
		this.eMail = eMail;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	@Override
	public String toString() {
		return "Account [name=" + name + ", eMail=" + eMail + "]";
	}
}
