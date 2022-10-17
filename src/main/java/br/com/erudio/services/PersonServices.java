package br.com.erudio.services;

import br.com.erudio.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll() {
        logger.info("Finding all people...");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding person...");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Rafael");
        person.setLastName("Silva");
        person.setAddress("Rua 1, nº 1");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Finding person...");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person...");
        return person;
    }

    public void delete(String id) {
        logger.info("Delete one person...");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Some Address in Brasil " + i);
        person.setGender("Male");

        return person;
    }
}
