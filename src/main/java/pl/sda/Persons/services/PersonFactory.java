package pl.sda.Persons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.Persons.model.CreatePersonRequest;
import pl.sda.Persons.model.Person;
import pl.sda.Persons.repositories.PersonRepository;

@Component
public class PersonFactory {

    private PersonRepository personRepository;

    @Autowired
    public PersonFactory(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void createPerson(CreatePersonRequest personRequest){
        Person personToAdd = Person.builder()
                .name(personRequest.getName())
                .surname(personRequest.getSurname())
                .age(personRequest.getAge())
                .city(personRequest.getCity())
                .height(personRequest.getHeight())
                .sex(personRequest.getSex())
                .build();

        personRepository.save(personToAdd);
    }

}
