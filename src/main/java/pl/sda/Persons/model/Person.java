package pl.sda.Persons.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
//@Document(collection = "persons")
public class Person {

    @Id
    private String id;

    private String name;

    private String surname;

    private Integer age;

    private String city;

    private Integer height;

    private Sex sex;

}
