package adaydoner.jpahibernatecourse05.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "Course")
@NamedQueries(value = { 
		@NamedQuery(name = "query_get_all_courses", query = "Select c FROM Course c"),
		@NamedQuery(name = "query_with_where_name_like_call", query = "SELECT c FROM Course c WHERE name like '%call%'") 
		})
@Cacheable
@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause="is_deleted = false")
public class Course {

	private static Logger logger = LoggerFactory.getLogger(Course.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	
	//one side of the OneToMany default fetchtype is lazy.
	@OneToMany(mappedBy="course")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy= "courses")
	private List<Student> students = new ArrayList<>();

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="is_deleted")
	private boolean isDeleted;

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}
	
	@PreRemove
	private void preRemove(){
		logger.info("\n\n>>>> Course.class preRemove method...");
		this.isDeleted=true;
	}

	/*
	 * getters and setters
	 */


	
	public Long getId() {
		return id;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review review){
		this.reviews.add(review);
	}
	
	public void removeReview(Review review){
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}

}
