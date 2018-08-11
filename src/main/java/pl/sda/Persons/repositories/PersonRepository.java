package pl.sda.Persons.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.sda.Persons.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findAllByName(String name);

    List<Person> findAllByCityOrderBySurnameAsc(String city);

    List<Person> findByAgeBetween(Integer from, Integer to);

    Long countByName(String name);

    Page<Person> findAllBy(Pageable pageable);

    List<Person> findByNameContaining(String name);
}
