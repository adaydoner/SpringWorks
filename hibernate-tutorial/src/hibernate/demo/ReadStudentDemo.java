package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		
		try {
			// create a student object
			System.out.println("creating a new student object...");
			Student tmpStudent = new Student("Duffy","Duck","duffy@dogan.com");
			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			session.save(tmpStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Saved student. Generated id " + tmpStudent.getId());

			
			// retrieve the student object
			System.out.println("\n\nGetting student with id :" + tmpStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student retrievedStudent = session.get(Student.class, tmpStudent.getId());
			System.out.println("Retrieved Object : " + retrievedStudent.toString());
			session.getTransaction().commit();
			
			
			System.out.println("Its over...");
			

		} finally {
			factory.close();
		}
	}
}
