package adaydoner.jpahibernatecourse05.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import adaydoner.jpahibernatecourse05.entities.Passport;
import adaydoner.jpahibernatecourse05.entities.Student;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDAOJPAImplTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentDAOJPAImpl studentDAO;
	
	@Autowired
	private EntityManager em;
	
	@Test
	@Transactional
	public void someTest() {
		studentDAO.playWithEm();
		Student student = em.find(Student.class, 20001L);
		logger.info(">>>> Student -> {}", student);
		
		Passport passport = student.getPassport();
		logger.info(">>>> Passport -> {}", passport);
		
		passport.setNumber("from test method change passport number");
		logger.info(">>>> Passport -> {}", passport.getNumber());
		
		student.setName("from test method change student name");
		logger.info(">>>> Student -> {}", student.getName());
	}
	
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info(">>>> Student -> {}", student);
		
		// if we annotate this method or class with @Transactional , hibernate wont kill transaction after 33. line so it will be able to fetch this passport with not killed session. 
		logger.info(">>>> Student passport details are -> {}",student.getPassport());
	}
	
	
	
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 30001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}



}
