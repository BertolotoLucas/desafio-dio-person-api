package br.com.lucasbertoloto.personapi.service;

import br.com.lucasbertoloto.personapi.dto.MessageResponseDTO;
import br.com.lucasbertoloto.personapi.dto.PersonDTO;
import br.com.lucasbertoloto.personapi.entity.Person;
import br.com.lucasbertoloto.personapi.mapper.PersonMapper;
import br.com.lucasbertoloto.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person person = personMapper.toModel(personDTO);
        Person save = personRepository.save(person);
        return MessageResponseDTO.builder().message("Created person with ID: " + save.getId()).build();
    }

    public List<PersonDTO> listAll() {
        List<Person> all = personRepository.findAll();
        return all.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }
}
