package pl.sda.Persons.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class CreatePersonRequest {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private Integer age;

    @NotNull
    private String city;

    @NotNull
    private Integer height;

    @NotNull
    private Sex sex;
}
