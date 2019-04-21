package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class DeleteDemoApp {
	
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
			
			// get instructor by primary key/id
			Instructor tmpInstructor = session.get(Instructor.class, 2);
			
			// delete instructor
			if(tmpInstructor != null){
				/*
				 * Note this would also delete associated instructor_detail entry, because we set cascade=cascadetype.all
				 */
				System.out.println("Deleting instructor : " + tmpInstructor.toString());
				
				session.delete(tmpInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Its over...");
			

		} finally {
			factory.close();
		}
	}
}
