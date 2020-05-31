package adaydoner.jpahibernatecourse03.jpa;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import adaydoner.jpahibernatecourse03.entities.Person;

@Transactional
@Repository
public class PersonJPARepository {

	@PersistenceContext
	EntityManager entityManager;
	
	
	public List<Person> getAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("get all persons", Person.class);
		return namedQuery.getResultList();
		
	}
	
	public Person getPersonById(long personId){
		return entityManager.find(Person.class, personId);
	}
	
	public Person updatePerson(Person person){
		return entityManager.merge(person);
	}
	
	public Person insertPerson(Person person){
		return entityManager.merge(person);
	}
	
	public void deletePersonById(long personId){
		Person deletePerson = getPersonById(personId);
		entityManager.remove(deletePerson);
	}
}
