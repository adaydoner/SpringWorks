package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class CreateDemoApp {
	
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
			// create the objects
			Instructor tmpInstructor = new Instructor("ali", "dogan", "alidogan@gmail.com");
			InstructorDetail tmpInstructorDetail = new InstructorDetail("https://www.youtube.com/alidoganaydoner", "smashing keyboard");
			
			// associate the objects
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			//save the instructor, since we set cascadeType.All its going to save instructor_detail as well, cause they'r associated
			System.out.println("Saving instructor : " + tmpInstructor.toString());
			session.save(tmpInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Its over...");
			

		} finally {
			factory.close();
		}
	}
}
