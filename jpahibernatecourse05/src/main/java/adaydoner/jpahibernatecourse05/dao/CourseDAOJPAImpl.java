package adaydoner.jpahibernatecourse05.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adaydoner.jpahibernatecourse05.entities.Course;

@Repository
@Transactional
public class CourseDAOJPAImpl implements Dao<Course> {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;

	@Override
	public Course findById(Long theId) {
		return em.find(Course.class, theId);
	}

	@Override
	public Course save(Course course) {
		if(course.getId() == null){
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}

	@Override
	public void deleteById(Long theId) {
		Course courseThatGoingToDelete = findById(theId);
		em.remove(courseThatGoingToDelete);
	}
	
	
	public void playWithEm(){
		logger.info("\n\n\n>>>>>>>>>>>>>>>>>>>>>> Playing with Entity Manager...");
		Course theCourse = new Course("Course for Entity Manager");
		em.persist(theCourse);
		em.flush();
		
		Course theCourse2 = findById(10001L);
		theCourse2.setName("Lernen Deutsch");
		em.persist(theCourse2);
		
	}

}
















