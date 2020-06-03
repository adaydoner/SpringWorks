package adaydoner.jpahibernatecourse05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import adaydoner.jpahibernatecourse05.dao.CourseDAOJPAImpl;
import adaydoner.jpahibernatecourse05.dao.StudentDAOJPAImpl;
import adaydoner.jpahibernatecourse05.entities.Course;
import adaydoner.jpahibernatecourse05.entities.Passport;
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
		logger.info("\n>>>> Course with id 10001 : {}",courseDAO.findById((long) 10001));
		Course course = new Course("Memory Management");
		logger.info("\n>>>> Course inserted : {}",courseDAO.save(course));
		course.setName("Fiction");
		course = courseDAO.save(course);
		logger.info("\n>>>> Updated course' name that has id {} to Fiction : {}",course.getId(),courseDAO.findById((long) 10004));
		course.setName("Another Fiction");
		course = courseDAO.save(course);
		logger.info("\n>>>> Updated course' name that has id {} to Fiction : {}",course.getId(),courseDAO.findById((long) 10004));
		
		logger.info("\n\n\n\n\n>>>> Student with id 20001 : {}",studentDAO.findById((long) 20001));
		Student theStudent = new Student("alidogan for test", new Passport("1234"));
		logger.info("\n>>>> student inserted : {}",studentDAO.save(theStudent));
		
		//courseDAO.playWithEm();
		
	}
}
