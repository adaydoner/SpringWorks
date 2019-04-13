package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		
		try {
			int studentId = 1;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve object based on the id
			Student retrievedStudent = session.get(Student.class, studentId);
			System.out.println("Retrieved Object : " + retrievedStudent.toString());
			
			System.out.println("Updating student...");
			retrievedStudent.setFirstName("Mranda");
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students with HQL
			System.out.println("Updating email for all students...");
			session.createQuery("update Student set email='aliali@aliali.com'").executeUpdate();
			

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Its over...");
			

		} finally {
			factory.close();
		}
	}
}
