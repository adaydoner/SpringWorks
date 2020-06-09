package adaydoner.jpahibernatecourse05.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import adaydoner.jpahibernatecourse05.entities.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDAOJPAImplTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseDAOSpringData courseDaoSpringData;

	@Autowired
	private EntityManager em;

	@Test
	@Transactional
	public void findById_10001() {
		logger.info("\n>>>> findById_10001 test method...");
		Optional<Course> theCourse = courseDaoSpringData.findById(10001L);
		if (theCourse.isPresent()) {
			logger.info("\n>>>> findById_10001 get...{}", courseDaoSpringData.getOne(10001L));
		}
	}

	@Test
	@Transactional
	public void findAllAndSort() {
		logger.info("\n>>>> findAll test method...");
		List<Course> allCourses = courseDaoSpringData.findAll();
		logger.info("\n>>>> findAll ...{}", allCourses);

		Sort sortDecendingByName = new Sort(Sort.Direction.DESC, "name");
		List<Course> allCoursesDescendingOrder = courseDaoSpringData.findAll(sortDecendingByName);
		logger.info("\n>>>> findAll descending by name...{}", allCoursesDescendingOrder);
	}

	@Test
	@Transactional
	public void pagination() {
		Page<Course> firstPage = courseDaoSpringData.findAll(PageRequest.of(0, 1));
		logger.info("\n>>>> First Page of all course ...{}", firstPage.getContent());

		Page<Course> secondPage = courseDaoSpringData.findAll(PageRequest.of(1, 1));
		logger.info("\n>>>> Second Page of all course ...{}", secondPage.getContent());

		Pageable thirdPage = secondPage.nextPageable();
		logger.info("\n>>>> Third Page of all course ...{}", courseDaoSpringData.findAll(thirdPage).getContent());

	}

	@Test
	@Transactional
	public void findByName() {
		logger.info("\n>>>> findByName test method...");
		List<Course> theCourse = courseDaoSpringData.findByName("Data Structures");
		logger.info("\n>>>> findByName get...{}", theCourse);
	}
	
	@Test
	@Transactional
	public void courseWithSInName() {
		logger.info("\n>>>> courseWithSInName test method...");
		//List<Course> theCourse = courseDaoSpringData.courseWithSInName();
		List<Course> theCourse = courseDaoSpringData.courseWithSInNameUsingNativeQuery();
		logger.info("\n>>>> courseWithSInName get...{}", theCourse);
	}
}



















