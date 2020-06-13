package adaydoner.jpahibernatecourse05.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import adaydoner.jpahibernatecourse05.entities.Course;

@RepositoryRestResource(path="courses")
public interface CourseDAOSpringData extends JpaRepository<Course, Long> {
	List<Course> findByNameAndId(String name, Long id);

	List<Course> findByName(String name);

	List<Course> countByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);
	
	
	@Query("Select  c  From Course c where name like '%S%'")
	List<Course> courseWithSInName();
	
	@Query(value="Select * From Course where name like '%S%'",nativeQuery=true)
	List<Course> courseWithSInNameUsingNativeQuery();
}
