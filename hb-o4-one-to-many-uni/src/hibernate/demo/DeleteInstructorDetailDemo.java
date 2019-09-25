package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		
		try {
			// start a transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId = 3;
			InstructorDetail tempInsDet = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("tempInsDet : " + tempInsDet.toString());
			
			//print the associated instructor
			System.out.println("Associated Instructor : " + tempInsDet.getInstructor().toString());
			
			//delete the instructor detail.
			System.out.println("Deleting tempInsDet : " + tempInsDet.toString());
			session.delete(tempInsDet);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Its over...");
			
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}
}
