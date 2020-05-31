package adaydoner.jpahibernatecourse03.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import adaydoner.jpahibernatecourse03.entities.Person;

@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int arg1) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	
	public List<Person> getAll(){
		return jdbcTemplate.query("SELECT * FROM Person WHERE visible=true"
				,new PersonRowMapper());
	}
	
	public Person getPersonById(long personId){
		return jdbcTemplate.queryForObject("SELECT * FROM Person WHERE id=? and visible=true"
				,new Object[]{personId} 
				,new PersonRowMapper());
	}
	
	
	public List<Person> getPersonsByName(String personName){
		return jdbcTemplate.query("SELECT * FROM Person WHERE name=? and visible=true"
				,new Object[]{personName}
				,new PersonRowMapper());
	}
	
	public List<Person> getPersonsByLocation(String personLocation){
		return jdbcTemplate.query("SELECT * FROM Person WHERE location=? and visible=true"
				,new Object[]{personLocation}
				,new PersonRowMapper());
	}
	
	public int deletePersonById(long personId){
		return jdbcTemplate.update(
				"UPDATE Person "
				+ "SET visible=false "
				+ "WHERE (id = ? and visible = true)"
				,new Object[]{personId});
	}
	
	public int insertPerson(Person person){
		return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(?, ?, ?, ?)"
				,new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int updatePerson(Person person){
		return jdbcTemplate.update(
				"UPDATE Person "
				+ "SET name=?, location=?, birth_date=? "
				+ "WHERE id=?"
				,new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
	}
	
}
