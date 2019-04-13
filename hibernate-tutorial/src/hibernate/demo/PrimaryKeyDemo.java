package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// create 3 student objects
			System.out.println("creating 3 student object...");
			Student tmpStudent1 = new Student("Bonita","Applebum","Bonita@dogan.com");
			Student tmpStudent2 = new Student("Paul","Doe","Paul@dogan.com");
			Student tmpStudent3 = new Student("John","Public","John@dogan.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the students...");
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			session.save(tmpStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Its over...");
			

		} finally {
			factory.close();
		}
	}
}
