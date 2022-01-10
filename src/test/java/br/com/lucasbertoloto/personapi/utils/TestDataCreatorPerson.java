package br.com.lucasbertoloto.personapi.utils;

import br.com.lucasbertoloto.personapi.entity.Person;

public final class TestDataCreatorPerson {

    public TestDataCreatorPerson() {}

    public static Person.PersonBuilder newPersonBuilder(){
        return Person.builder()
                .id(TestsConstants.DEFAULT_PERSON_ID)
                .firstName(TestsConstants.DEFAULT_PERSON_FIRST_NAME)
                .lastName(TestsConstants.DEFAULT_PERSON_LAST_NAME)
                .cpf(TestsConstants.DEFAULT_PERSON_CPF)
                .birthDate(TestsConstants.DEFAULT_PERSON_BIRTH_DATE)
                .phones(TestsConstants.DEFAULT_PERSON_PHONES);
    }
}
