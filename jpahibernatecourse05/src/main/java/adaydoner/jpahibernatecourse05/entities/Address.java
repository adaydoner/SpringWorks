package adaydoner.jpahibernatecourse05.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String line1;
	private String city;
	
	public Address(){
		
	}
	
	public Address(String line1, String city) {
		super();
		this.line1 = line1;
		this.city = city;
	}
}
