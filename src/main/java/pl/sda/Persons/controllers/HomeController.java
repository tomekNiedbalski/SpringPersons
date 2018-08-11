package pl.sda.Persons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.Persons.model.CreatePersonRequest;
import pl.sda.Persons.model.Person;
import pl.sda.Persons.services.FindPersons;
import pl.sda.Persons.services.PersonFactory;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class HomeController {

    private PersonFactory personFactory;
    private FindPersons findPersons;

    @Autowired
    public HomeController(PersonFactory personFactory, FindPersons findPersons) {
        this.personFactory = personFactory;
        this.findPersons = findPersons;
    }

    @GetMapping("/all")
    public Page<Person> findAllPerson(@RequestParam Integer size, @RequestParam Integer pageNumber){
        Pageable pageable = new PageRequest(pageNumber, size);
        return findPersons.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable String id){
        return findPersons.findPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPerson(@RequestBody @Valid CreatePersonRequest personRequest){
        personFactory.createPerson(personRequest);
    }

    @GetMapping("/find")
    public List<Person> findByName(@RequestParam String name){
        return findPersons.findByName(name);
    }

    @GetMapping("/city")
    public List<Person> findByCitySortedBySurname(@RequestParam String city){
        return findPersons.findByCitySortedBySurname(city);
    }

    @GetMapping("/age")
    public List<Person> findByAgeBetween(@RequestParam Integer from, Integer to){
        return findPersons.findByAgeBetween(from, to);
    }

    @GetMapping("/count")
    public Long countByName(@RequestParam String name){
        return findPersons.countByName(name);
    }

    @GetMapping("/findLike")
    public List<Person> findAllByNameStartsWith(@RequestParam String name){
        return findPersons.findAllByNameStartWith(name);
    }
}
