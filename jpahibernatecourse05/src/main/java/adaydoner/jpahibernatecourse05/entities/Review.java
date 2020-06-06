package adaydoner.jpahibernatecourse05.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rating")
	private String rating;

	@Column(name = "description")
	private String description;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Student student;


	protected Review() {
	}

	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	/*
	 * getters and setters
	 */

	
	public Long getId() {
		return id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Review [rating=" + rating + ", description=" + description + "]";
	}
}
