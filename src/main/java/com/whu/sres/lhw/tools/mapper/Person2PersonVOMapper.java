package com.whu.sres.lhw.tools.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Description:
 * Created by lvhw on 2018/10/6 18:11.
 */
@Mapper
public interface Person2PersonVOMapper {
    Person2PersonVOMapper MAPPER = Mappers.getMapper(Person2PersonVOMapper.class);

    @Mappings({
            @Mapping(source = "birthDate", target = "birth", dateFormat = "yyyyMMdd HH:mm:ss"),
            @Mapping(target = "wallet", numberFormat = "######.000"),
    })

    /**
     * Person -->PersonVO
     */
    PersonVO fromPerson(Person person);

    /**
     * 反向转换 PersonVO --> Person
     */
    @InheritInverseConfiguration(name = "fromPerson")
    Person fromPersonVO(PersonVO personVO);

    List<PersonVO> fromPersonList(List<Person> persons);

    @InheritInverseConfiguration(name = "fromPersonList")
    List<Person> fromPersonVOList(List<PersonVO> personVOs);
}
