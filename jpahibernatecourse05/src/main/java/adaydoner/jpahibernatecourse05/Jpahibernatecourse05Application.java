package adaydoner.jpahibernatecourse05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import adaydoner.jpahibernatecourse05.dao.CourseDAOJPAImpl;
import adaydoner.jpahibernatecourse05.dao.StudentDAOJPAImpl;
import adaydoner.jpahibernatecourse05.entities.Course;
import adaydoner.jpahibernatecourse05.entities.Review;
import adaydoner.jpahibernatecourse05.entities.Student;

@SpringBootApplication
public class Jpahibernatecourse05Application implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseDAOJPAImpl courseDAO;
	
	@Autowired
	private StudentDAOJPAImpl studentDAO;

	public static void main(String[] args)  {
		SpringApplication.run(Jpahibernatecourse05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// soft delete demo
/*		logger.info("\n>>>> deleteById_10002 test method...");
		courseDAO.deleteById((long)10002);
		courseDAO.findById(10002L);*/
		
/*		logger.info("\n>>>> Course with id 10001 : {}",courseDAO.findById((long) 10001));
		Course course = new Course("Memory Management");
		logger.info("\n>>>> Course inserted : {}",courseDAO.save(course));
		course.setName("Fiction");
		course = courseDAO.save(course);
		logger.info("\n>>>> Updated course' name that has id {} to Fiction : {}",course.getId(),courseDAO.findById((long) 10004));
		course.setName("Another Fiction");
		course = courseDAO.save(course);
		logger.info("\n>>>> Updated course' name that has id {} to Fiction : {}",course.getId(),courseDAO.findById((long) 10004));
		Course course2 = courseDAO.findById(10004L);
		logger.info("\n>>>> course2 {}",course2);
		Course course3 = courseDAO.findById(10004L);
		logger.info("\n>>>> course3 {}",course3);
				
		logger.info("\n\n\n\n\n>>>> Student with id 20001 : {}",studentDAO.findById((long) 20001));
		Student theStudent = new Student("alidogan for test", new Passport("1234"));
		logger.info("\n>>>> student inserted : {}",studentDAO.save(theStudent));
		
		studentDAO.playWithEm();
		Student student = studentDAO.findById((long) 20001);
		logger.info(">>>> Student -> {}", student);
		
		Passport passport = student.getPassport();
		logger.info(">>>> Passport -> {}", passport);
*/
		
		//try addReviewsToCourse method at CourseDAOJPAImpl.java
		/*
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("4", "add review from addReviewsToCourse method"));
		reviews.add(new Review("9", "add another review from addReviewsToCourse method"));
		courseDAO.addReviewsToCourse(10001L, reviews);
		*/
		
		
		
		
		// try addStudentsAndCourses for student course relationship
		
		/*
		Student theStudent = studentDAO.findById(20001L);
		new Student("ali for test")
		studentDAO.addStudentsAndCourses(new Student("ali for test"), new Course("course testing"));
		*/
		
		
		
		// try addReviewsForStudent for student course review tables
/*		Student theStudent = studentDAO.findById(20001L);
		List<Review> reviews = Arrays.asList(
				new Review("5", "comment jane for test to null course"),
				new Review("4", "second comment jane for test to null course")
				);
		//new Student("ali for test")
		studentDAO.addReviewsForStudent(theStudent,reviews);*/
		
	}
}















