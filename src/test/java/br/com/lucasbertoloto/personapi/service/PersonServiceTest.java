package br.com.lucasbertoloto.personapi.service;

import br.com.lucasbertoloto.personapi.core.BaseUnitTest;
import br.com.lucasbertoloto.personapi.dto.PersonDTO;
import br.com.lucasbertoloto.personapi.entity.Person;
import br.com.lucasbertoloto.personapi.exception.PersonNotFoundException;
import br.com.lucasbertoloto.personapi.repository.PersonRepository;
import br.com.lucasbertoloto.personapi.utils.TestDataCreatorPerson;
import br.com.lucasbertoloto.personapi.utils.TestDataCreatorPersonDTO;
import br.com.lucasbertoloto.personapi.utils.TestsConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

public class PersonServiceTest extends BaseUnitTest {

    public PersonService victim;

    @Mock
    public PersonRepository repository;

    @BeforeEach
    void setUp() {
        victim = new PersonService(repository);
    }

    @Test
    void shouldReturnPersonWithIdOne() throws PersonNotFoundException {
        Person expectedPerson = TestDataCreatorPerson.newPersonBuilder().build();
        Mockito.when(repository.findById(TestsConstants.DEFAULT_PERSON_ID)).thenReturn(Optional.of(expectedPerson));
        PersonDTO dto = victim.findById(1L);

        Assertions.assertEquals(dto.getId(), expectedPerson.getId());
        Assertions.assertEquals(dto.getBirthDate(), expectedPerson.getBirthDate().toString());
        Assertions.assertEquals(dto.getFirstName(), expectedPerson.getFirstName());
        Assertions.assertEquals(dto.getLastName(), expectedPerson.getLastName());
        Assertions.assertEquals(dto.getCpf(), expectedPerson.getCpf());
        Assertions.assertEquals(dto.getPhones(), expectedPerson.getPhones());
    }
}
