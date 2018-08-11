package pl.sda.Persons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.sda.Persons.exceptions.PersonNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PersonControllerAdvisor {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePersonNotFound(PersonNotFoundException e){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMsg", e.getMessage());
        return errorMap;
    }
}
