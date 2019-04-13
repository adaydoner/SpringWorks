package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		
		try {
			/*int studentId = 1;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve object based on the id
			Student retrievedStudent = session.get(Student.class, studentId);
			System.out.println("Retrieved Object : " + retrievedStudent.toString());
			
			session.delete(retrievedStudent);
			
			System.out.println("Deleting student...");
			
			// commit the transaction
			session.getTransaction().commit();*/
			
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//delete students with HQL
			System.out.println("Deleting students id = 2...");
			session.createQuery("delete from Student where id=2").executeUpdate();
			

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Its over...");
			

		} finally {
			factory.close();
		}
	}
}
