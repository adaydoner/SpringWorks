package springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;	
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	public Student(){
		
		//populate country options : "Key/Code","Value/Label"
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("TR", "Turkey");
		countryOptions.put("GR", "Germany");
		countryOptions.put("FR", "France");
		countryOptions.put("USA", "United States");
	}

	/*
	 * getters and setters
	 */
	
	
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getCountry() {
		return country;
	}


	public String getLastName() {
		return lastName;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	
}
