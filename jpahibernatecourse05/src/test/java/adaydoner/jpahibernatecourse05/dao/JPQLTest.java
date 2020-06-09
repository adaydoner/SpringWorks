package adaydoner.jpahibernatecourse05.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void selectAllFromCourseTable() {
		// Named queries at Course entity class
		List arrayList = em.createNamedQuery("query_get_all_courses").getResultList();
		logger.info("\n\n>>>>>>> Select c FROM Course c -> {}", arrayList);
	}
	
	
	@Test
	public void selectAllFromCourseTable_typed() {
		// Named queries at Course entity class
		List arrayList = em.createNamedQuery("query_get_all_courses",Course.class).getResultList();
		logger.info("\n\n>>>>>>> Select c FROM Course c , entity type explicitly given -> {}", arrayList);
	}
	
	
	@Test
	public void selectFromCourseTable_where() {
		// Named queries at Course entity class
		List arrayList = em.createNamedQuery("query_with_where_name_like_call",Course.class).getResultList();
		logger.info("\n\n>>>>>>> Select c FROM Course c WHERE name like '%call%' -> {}", arrayList);
	}

	@Test
	public void select_courses_not_have_students() {
		List arrayList = em.createQuery("SELECT c FROM Course c WHERE c.students is empty",Course.class).getResultList();
		logger.info("\n\n>>>>>>> Courses dont have students -> {}", arrayList);
	}
	
	@Test
	public void select_courses_have_more_than_two_students() {
		List arrayList = em.createQuery("SELECT c FROM Course c WHERE size(c.students) >= 2",Course.class).getResultList();
		logger.info("\n\n>>>>>>> Courses have more than 2 students -> {}", arrayList);
	}
	
	@Test
	public void select_courses_ordered_by_students() {
		List arrayList = em.createQuery("SELECT c FROM Course c order by size(c.students) desc",Course.class).getResultList();
		logger.info("\n\n>>>>>>> Courses descending order by students -> {}", arrayList);
	}
	
	@Test
	public void students_with_passport_in_a_certain_pattern() {
		List arrayList = em.createQuery("SELECT s FROM Student s WHERE s.passport.number like '%02%'",Student.class).getResultList();
		logger.info("\n\n>>>>>>> Students whose passport number has 02 in it -> {}", arrayList);
	}
	
	@Test
	public void join(){
		Query query = em.createQuery("SELECT c,s FROM Course c JOIN c.students s");
		List<Object[]> list = query.getResultList();
		logger.info("\n\n>>>>>>> Join result size-> {}",list.size());
		for (Object[] objects : list) {
			logger.info("\n\n>>>>>>> Join course{} and student{}",objects[0],objects[1]);
		}
	}
	
	@Test
	public void left_join(){
		Query query = em.createQuery("SELECT c,s FROM Course c LEFT JOIN c.students s");
		List<Object[]> list = query.getResultList();
		logger.info("\n\n>>>>>>> Join result size-> {}",list.size());
		for (Object[] objects : list) {
			logger.info("\n\n>>>>>>> Join course{} and student{}",objects[0],objects[1]);
		}
	}
	
	@Test
	public void cross_join(){
		Query query = em.createQuery("SELECT c,s FROM Course c, Student s");
		List<Object[]> list = query.getResultList();
		logger.info("\n\n>>>>>>> Join result size-> {}",list.size());
		for (Object[] objects : list) {
			logger.info("\n\n>>>>>>> Join course{} and student{}",objects[0],objects[1]);
		}
	}
	
	

}
