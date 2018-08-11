package pl.sda.Persons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sda.Persons.exceptions.PersonNotFoundException;
import pl.sda.Persons.model.Person;
import pl.sda.Persons.repositories.PersonRepository;
import java.util.List;

@Service
public class FindPersons {

    private PersonRepository personRepository;

    @Autowired
    public FindPersons(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAllBy(pageable);
    }

    public Person findPersonById(String id) {
        Person foundPerson = personRepository.findOne(id);

        if (foundPerson == null) {
            throw new PersonNotFoundException("There is no person with id: " + id);
        } else {
            return foundPerson;
        }
    }

    public List<Person> findByName(String name) {
        return personRepository.findAllByName(name);
    }

    public List<Person> findByCitySortedBySurname(String city) {
        return personRepository.findAllByCityOrderBySurnameAsc(city);
    }

    public List<Person> findByAgeBetween(Integer from, Integer to) {
        return personRepository.findByAgeBetween(from, to);
    }

    public Long countByName(String name) {
        return personRepository.countByName(name);
    }

    public List<Person> findAllByNameStartWith(String name) {
        return personRepository.findByNameContaining(name);
    }
}
