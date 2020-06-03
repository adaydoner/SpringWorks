package adaydoner.jpahibernatecourse05.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import adaydoner.jpahibernatecourse05.entities.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void selectAllFromCourseTable() {
		List arrayList = em.createNamedQuery("query_get_all_courses").getResultList();
		logger.info("\n\n>>>>>>> Select c FROM Course c -> {}", arrayList);
	}
	
	
	@Test
	public void selectAllFromCourseTable_typed() {
		List arrayList = em.createNamedQuery("query_get_all_courses",Course.class).getResultList();
		logger.info("\n\n>>>>>>> Select c FROM Course c , entity type explicitly given -> {}", arrayList);
	}
	
	
	@Test
	public void selectFromCourseTable_where() {
		List arrayList = em.createNamedQuery("query_with_where_name_like_call",Course.class).getResultList();
		logger.info("\n\n>>>>>>> Select c FROM Course c WHERE name like '%call%' -> {}", arrayList);
	}


}
