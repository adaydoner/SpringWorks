package adaydoner.jpahibernatecourse05.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import adaydoner.jpahibernatecourse05.entities.Course;
import adaydoner.jpahibernatecourse05.entities.Review;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDAOJPAImplTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseDAOJPAImpl courseDAO;
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void findById_10001() {
		logger.info("\n>>>> findById_10001 test method...");
		Course theCourse = courseDAO.findById((long)10001);
		assertEquals("Data Structures",theCourse.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_10001() {
		logger.info("\n>>>> deleteById_10001 test method...");
		courseDAO.deleteById((long)10001);
		assertNull(courseDAO.findById((long)10001));
	}
	
	@Test
	@DirtiesContext
	public void updateTest() {
		Course course = courseDAO.findById((long)10001);
		course.setName("entry updated");
		courseDAO.save(course);
		assertEquals("entry updated", courseDAO.findById((long)10001).getName());
	}
	
	// test onetomany relationship from one's side.
	@Test
	@Transactional
	public void retrieveReviewForCourse(){
		Course course = courseDAO.findById(10001L);
		logger.info("{}",course.getReviews());
	}
	
	
	// test onetomany relationship from many's side.
	@Test
	@Transactional
	public void retrieveCourseFromReview(){
		Review review = em.find(Review.class, 40002L);
		logger.info("{}",review.getCourse());
	}
	
	@Test
	public void findById_10001_first_level_cache() {
		logger.info("\n>>>> findById_10001 test method...");
		Course theCourse = courseDAO.findById(10001L);
		logger.info("\n>>>> findById_10001 get...{}", theCourse);
		
		Course theCourse2 = courseDAO.findById(10001L);
		logger.info("\n>>>> findById_10001 get again...{}", theCourse2);
	}
}






















