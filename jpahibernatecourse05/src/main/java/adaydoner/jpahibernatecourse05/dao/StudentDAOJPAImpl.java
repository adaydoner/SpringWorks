package adaydoner.jpahibernatecourse05.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adaydoner.jpahibernatecourse05.entities.Course;
import adaydoner.jpahibernatecourse05.entities.Student;

@Repository
@Transactional
public class StudentDAOJPAImpl implements Dao<Student> {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;

	@Override
	public Student findById(Long theId) {
		return em.find(Student.class, theId);
	}

	@Override
	public Student save(Student student) {
		if(student.getPassport().getNumber().length() > 0){
			em.persist(student.getPassport());
		}
		if(student.getId() == null){
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	@Override
	public void deleteById(Long theId) {
		Student StudentThatGoingToDelete = findById(theId);
		em.remove(StudentThatGoingToDelete);
	}
	
	
	public void playWithEm(){
		logger.info("\n\n\n>>>>>>>>>>>>>>>>>>>>>> Playing with Entity Manager...");
		Student theStudent = new Student("Student for Entity Manager");
		em.persist(theStudent);
		
	}

	public void addStudentsAndCourses(Student student, Course course) {
		
		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(course);
		em.persist(student);
	}
	
	public void addNewCourseToStudent(Student student, Course course) {
		student = em.merge(student);
		student.addCourse(course);
		course.addStudent(student);
		em.persist(course);
		em.persist(student);
	}

}
















