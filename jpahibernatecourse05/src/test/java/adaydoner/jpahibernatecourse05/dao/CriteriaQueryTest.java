package adaydoner.jpahibernatecourse05.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import adaydoner.jpahibernatecourse05.entities.Course;
import adaydoner.jpahibernatecourse05.entities.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void criteria_query_basic() {
		//SELECT * FROM Course
		
		// Create CriteriaBuilder instance with entity manager
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		//Create Query with criteriaBuilder instance and spesify your expected result object
		CriteriaQuery<Course> createQuery = criteriaBuilder.createQuery(Course.class);
		
		Root<Course> fromCourse = createQuery.from(Course.class);
		
		// Named queries at Course entity class
		TypedQuery<Course> query = em.createQuery(createQuery.select(fromCourse));
		List<Course> resultList = query.getResultList();
		logger.info("\n\n>>>>>>> Select c FROM Course c -> {}", resultList);
	}
	
	@Test
	public void courses_like_data() {
		//SELECT c FROM Course c WHERE c.name like '%Data%'
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Course> createQuery = criteriaBuilder.createQuery(Course.class);
		
		Root<Course> fromCourse = createQuery.from(Course.class);
		
		Predicate likeData = criteriaBuilder.like(fromCourse.get("name"), "%Data%");
		createQuery.where(likeData);

		
		TypedQuery<Course> query = em.createQuery(createQuery.select(fromCourse));
		List<Course> resultList = query.getResultList();
		logger.info("\n\n>>>>>>> SELECT c FROM Course c WHERE c.name like '%Data%' -> {}", resultList);
		
	}
	
	@Test
	public void courses_without_students() {
		//SELECT c FROM Course c WHERE c.students is empty
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Course> createQuery = criteriaBuilder.createQuery(Course.class);
		
		Root<Course> fromCourse = createQuery.from(Course.class);
		
		Predicate emptyStudents = criteriaBuilder.isEmpty(fromCourse.get("students"));
		createQuery.where(emptyStudents);

		
		TypedQuery<Course> query = em.createQuery(createQuery.select(fromCourse));
		List<Course> resultList = query.getResultList();
		logger.info("\n\n>>>>>>> SELECT c FROM Course c WHERE c.students is empty -> {}", resultList);
		
	}
	
	
	@Test
	public void join() {
		// "Select c From Course c join c.students s"

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Course> createQuery = criteriaBuilder.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> fromCourse = createQuery.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Join<Object, Object> join = fromCourse.join("students");

		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(createQuery.select(fromCourse));

		List<Course> resultList = query.getResultList();

		logger.info("\n\n>>>>>>> Select c From Course c join c.students s -> {}", resultList);
	}
}
















