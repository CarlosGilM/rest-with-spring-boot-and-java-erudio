package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Finding all people!");
		return repository.findAll();
	}

	public Person findById(Long id) {
		logger.info("Finding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}

	public Person Create(Person P) {
		logger.info("Creating one person!");
		return repository.save(P);
	}

	public Person Update(Person P) {
		logger.info("Updating one person!");
		Person Entity = repository.findById(P.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		Entity.setFirstName(P.getFirstName());
		Entity.setLastName(P.getLastName());
		Entity.setAddress(P.getAddress());
		Entity.setGender(P.getGender());

		return repository.save(P);
	}

	public void Delete(Long id) {
		logger.info("Deleting one person!");
		Person Entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(Entity);
	}

	/*
	 * private Person mockPerson(int i) {
	 * logger.info("Finding all people!");
	 * Person person = new Person();
	 * person.setId(counter.incrementAndGet());
	 * person.setFirstName("Person name " + i);
	 * person.setLastName("Last name " + i);
	 * person.setAddress("Some address in Brasil " + i);
	 * person.setGender("Male");
	 * return person;
	 * }
	 */
}
