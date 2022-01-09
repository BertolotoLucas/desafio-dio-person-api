package br.com.lucasbertoloto.personapi.service;

import br.com.lucasbertoloto.personapi.dto.MessageResponseDTO;
import br.com.lucasbertoloto.personapi.dto.PersonDTO;
import br.com.lucasbertoloto.personapi.entity.Person;
import br.com.lucasbertoloto.personapi.exception.PersonNotFoundException;
import br.com.lucasbertoloto.personapi.mapper.PersonMapper;
import br.com.lucasbertoloto.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return generateMessageResponseDTO("Created person with ID: ", save.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> all = personRepository.findAll();
        return all.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        personRepository.delete(person);
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person person = personMapper.toModel(personDTO);
        Person update = personRepository.save(person);
        return generateMessageResponseDTO("Updated person with ID: ", update.getId());
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(
                () -> new PersonNotFoundException(id)
        );
    }

    private MessageResponseDTO generateMessageResponseDTO(String message, Long id) {
        return MessageResponseDTO.builder().message(message + id).build();
    }
}
