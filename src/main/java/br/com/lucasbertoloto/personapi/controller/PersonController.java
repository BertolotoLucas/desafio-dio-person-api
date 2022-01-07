package br.com.lucasbertoloto.personapi.controller;

import br.com.lucasbertoloto.personapi.dto.MessageResponseDTO;
import br.com.lucasbertoloto.personapi.entity.Person;
import br.com.lucasbertoloto.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/people")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person save = personRepository.save(person);
        return MessageResponseDTO.builder().message("Created person with ID: " + save.getId()).build();
    }
}
