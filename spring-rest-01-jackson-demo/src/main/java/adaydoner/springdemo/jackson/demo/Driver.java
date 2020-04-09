package adaydoner.springdemo.jackson.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try{
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read json file and map/convert to Jaca POJO
			// data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First Name : " + theStudent.getFirstName());
			System.out.println("Last Name : " + theStudent.getLastName());
			
			
			// print out address : street and city
			Address tmpAddress = theStudent.getAddress();
			
			System.out.println("Street : " + tmpAddress.getStreet());
			System.out.println("City : " + tmpAddress.getCity());
			
			
			//print out the languages
			String[] languages = theStudent.getLanguages();
			for (int i = 0; i < languages.length; i++) {
				System.out.println(languages[i]);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
