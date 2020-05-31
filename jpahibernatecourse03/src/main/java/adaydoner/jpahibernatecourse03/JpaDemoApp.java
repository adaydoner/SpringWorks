package adaydoner.jpahibernatecourse03;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import adaydoner.jpahibernatecourse03.entities.Person;
import adaydoner.jpahibernatecourse03.jpa.PersonJPARepository;

@SpringBootApplication
public class JpaDemoApp implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJPARepository dao;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//logger.info("\nAll users -> {}",dao.getAll());
		logger.info("\nUser with id 10001 -> {}", dao.getPersonById(10001));
		logger.info("\n>>>> INSERT PERSON");
		logger.info("\nInsert Person >>,  'Jess', 'Finland','1990-04-08 00:00:00' --> {}", dao.insertPerson(new Person("Jess", "Finland", new Date())));
		logger.info("\n>>>> UPDATE PERSON");
		logger.info("\nUpdate person with id 10003 name with Taki --> {}", dao.updatePerson(new Person(10003, "Taki", "Finland", new Date())));
		logger.info("\n>>>> DELETE USER with id 10002");
		dao.deletePersonById(10002);
		logger.info("\nAll users -> {}",dao.getAll());
		/*logger.info("\nUser with name Kristen -> {}", dao.getPersonsByName("Kristen"));
		logger.info("\nUser with location St.Petersburg -> {}", dao.getPersonsByLocation("St.Petersburg"));
		*/
	}

}
