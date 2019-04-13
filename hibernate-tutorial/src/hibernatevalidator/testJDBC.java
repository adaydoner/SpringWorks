package hibernatevalidator;

import java.sql.Connection;
import java.sql.DriverManager;


public class testJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		try{
			System.out.println("Connecting to database : " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl,userName,password);
			System.out.println("Connection successful !.");
		} catch (Exception e ){
			e.printStackTrace();
		}

	}
}
