package br.com.lucasbertoloto.personapi.mapper;

import br.com.lucasbertoloto.personapi.dto.PersonDTO;
import br.com.lucasbertoloto.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person model);
}
