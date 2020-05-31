/*package adaydoner.jpahibernatecourse03;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import adaydoner.jpahibernatecourse03.entities.Person;
import adaydoner.jpahibernatecourse03.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class JdbcDemoApp implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nAll users -> {}",dao.getAll());
		logger.info("\nUser with id 10001 -> {}", dao.getPersonById(10001));
		logger.info("\nUser with name Kristen -> {}", dao.getPersonsByName("Kristen"));
		logger.info("\nUser with location St.Petersburg -> {}", dao.getPersonsByLocation("St.Petersburg"));
		logger.info(">>>> DELETE USER");
		logger.info("\nDelete user with id 10002 -> {}", dao.deletePersonById(10002));
		logger.info("\nAll users -> {}",dao.getAll());
		logger.info(">>>> INSERT PERSON");
		logger.info("\nInsert Person >> 10004,  'Jess', 'Finland','1990-04-08 00:00:00' --> {}",dao.insertPerson(new Person(10004, "Jess", "Finland", new Date())));
		logger.info("\nAll users -> {}",dao.getAll());
		logger.info(">>>> UPDATE PERSON");
		logger.info("\nUpdate person with id 10004 name with Taki --> {}", dao.updatePerson(new Person(10004, "Taki", "Finland", new Date())));
		logger.info("\nAll users -> {}",dao.getAll());
	}

}
*/