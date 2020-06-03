package adaydoner.jpahibernatecourse05.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import adaydoner.jpahibernatecourse05.entities.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDAOJPAImplTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseDAOJPAImpl courseDAO;
	
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

}
