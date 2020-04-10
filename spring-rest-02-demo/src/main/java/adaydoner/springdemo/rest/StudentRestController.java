package adaydoner.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import adaydoner.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	@PostConstruct
	public void loadTestData() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("ali", "dogan"));
		theStudents.add(new Student("mari", "teli"));
		theStudents.add(new Student("cylie", "efef"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;

	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if(studentId < 0 || theStudents.size()  <= studentId) {
			throw new StudentNotFoundException("with this given id , student not found : " + studentId);
		}
		return theStudents.get(studentId);

	}
}
