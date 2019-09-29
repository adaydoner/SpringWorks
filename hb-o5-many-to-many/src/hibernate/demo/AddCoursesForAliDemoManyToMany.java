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

public class AddCoursesForAliDemoManyToMany {

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

			//create more courses
			System.out.println("Creating courses...");
			Course course1 = new Course("Android Programming");
			Course course2 = new Course("IOS Development");
			System.out.println("Created courses : " + course1 + course2);
			
			//add ali to those courses
			System.out.println("Adding student to the courses");
			course1.addStudent(theStudent);
			course2.addStudent(theStudent);
			System.out.println("Student added : ");
			
			//save the courses
			System.out.println("Saving the courses...");
			session.save(course1);
			session.save(course2);
			System.out.println("Saved courses : " + course1 + course2);
			
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
