/*
 * for hb03-one-to-many
 */
package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemoOneToManyUni {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the course
			int theId = 10;
			Course theCourse = session.get(Course.class, theId);
			
			//print the course
			System.out.println("Deleting the course : " + theCourse);

			//print the course reviews
			System.out.println(theCourse.getReviews());
			
			//delete the course
			session.delete(theCourse);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Its over...");
			

		} finally {
			//add clean up code
			session.close();
			factory.close();
		}
	}
}
