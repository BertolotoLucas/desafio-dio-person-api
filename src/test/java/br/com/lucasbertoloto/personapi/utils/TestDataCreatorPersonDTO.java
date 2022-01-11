package br.com.lucasbertoloto.personapi.utils;

import br.com.lucasbertoloto.personapi.dto.PersonDTO;

import java.time.format.DateTimeFormatter;

public final class TestDataCreatorPersonDTO {

    public TestDataCreatorPersonDTO() {}

    public static PersonDTO.PersonDTOBuilder newPersonBuilder(){
        return PersonDTO.builder()
                .id(TestsConstants.DEFAULT_PERSON_ID)
                .firstName(TestsConstants.DEFAULT_PERSON_FIRST_NAME)
                .lastName(TestsConstants.DEFAULT_PERSON_LAST_NAME)
                .cpf(TestsConstants.DEFAULT_PERSON_CPF)
                .birthDate(TestsConstants.DEFAULT_PERSON_BIRTH_DATE.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .phones(TestsConstants.DEFAULT_PERSON_PHONES);
    }
}
