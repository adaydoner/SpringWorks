package testclasses;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBCConnection {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/employees?useSSL=false&serverTimezone=UTC";
		String user = "test_company";
		String pass = "test_company";
		try {
			System.out.println("Trying to connect database -> " + jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connection successful !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
