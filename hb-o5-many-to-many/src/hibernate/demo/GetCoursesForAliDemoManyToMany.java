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
import hibernate.demo.entity.Student;

public class GetCoursesForAliDemoManyToMany {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			//get student ali from the database
			int studentId = 1;
			Student theStudent = session.get(Student.class, studentId);
			
			System.out.println("Loaded student " + theStudent);
			System.out.println("Courses : " + theStudent.getCourses());
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Its over...");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
