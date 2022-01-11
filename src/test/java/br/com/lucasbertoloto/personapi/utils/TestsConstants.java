package br.com.lucasbertoloto.personapi.utils;

import br.com.lucasbertoloto.personapi.entity.Phone;
import br.com.lucasbertoloto.personapi.enums.PhoneType;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class TestsConstants {
    public static final Long DEFAULT_PERSON_ID = 1L;
    public static final String DEFAULT_PERSON_FIRST_NAME = "Lucas";
    public static final String DEFAULT_PERSON_LAST_NAME = "Bertoloto";
    public static final String DEFAULT_PERSON_CPF = "30214085082";
    public static final LocalDate DEFAULT_PERSON_BIRTH_DATE = LocalDate.of(1999,2,17);
    public static final List<Phone> DEFAULT_PERSON_PHONES = generateDefaultsPhones();

    public TestsConstants() {}

    private static List<Phone> generateDefaultsPhones(){
        List<Phone> phones = new ArrayList<>();
        phones.add(Phone.builder().id(1L).type(PhoneType.COMMERCIAL).number("(21)999999999").build());
        phones.add(Phone.builder().id(2L).type(PhoneType.MOBILE).number("(21)999999999").build());
        phones.add(Phone.builder().id(3L).type(PhoneType.HOME).number("(21)99999999").build());
        return phones;
    }

}
