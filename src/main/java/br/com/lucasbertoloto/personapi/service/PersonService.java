package br.com.lucasbertoloto.personapi.service;

import br.com.lucasbertoloto.personapi.dto.MessageResponseDTO;
import br.com.lucasbertoloto.personapi.dto.PersonDTO;
import br.com.lucasbertoloto.personapi.entity.Person;
import br.com.lucasbertoloto.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        try {
            Person person = Person.builder().cpf(personDTO.getCpf()).firstName(personDTO.getFirstName()).lastName(personDTO.getLastName())
                    .phones(personDTO.getPhones()).birthDate(new SimpleDateFormat("dd/MM/yyyy").parse(personDTO.getBirthDate())).build();

            Person save = personRepository.save(person);
            return MessageResponseDTO.builder().message("Created person with ID: " + save.getId()).build();
        } catch (ParseException e) {
            e.printStackTrace();
            return MessageResponseDTO.builder().message("Error: " + e.getMessage()).build();
        }
    }
}
