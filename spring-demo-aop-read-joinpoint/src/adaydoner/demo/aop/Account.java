package adaydoner.demo.aop;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private String name;
	private String eMail;
	
	
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
	
	
}
