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

public class CreateCourseAndReviewsDemoOneToManyUni {

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

			// create a course
			Course theCourse = new Course("CS50");

			// save the course ... and leverage the cascade all
			System.out.println("Saving the course .. ");
			session.save(theCourse);
			System.out.println("Saved the course : " + theCourse);

			//create the students
			Student student1 = new Student("Ali", "Dogan", "ali@dogan.com");
			Student student2 = new Student("M�ge", "Leyla", "muge@leyla.com");
			
			//saving the students
			System.out.println("Saving students.. ");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students : " + theCourse.get);

			
			// add some reviews
			Review review = new Review("Nice tutorial by Harvard.");
			Review review2 = new Review("I remember everything I forget");
			theCourse.addReview(review);
			theCourse.addReview(review2);


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
