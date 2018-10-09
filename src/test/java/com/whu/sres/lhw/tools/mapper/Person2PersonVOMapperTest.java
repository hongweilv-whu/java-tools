package com.whu.sres.lhw.tools.mapper;

import com.whu.sres.lhw.tools.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * Created by lvhw on 2018/10/6 18:16.
 */
public class Person2PersonVOMapperTest extends BaseTest {

    @Test
    public void person2PersonVO() {
        Person p = new Person();
        p.setName("p1");
        p.setAge(10);
        p.setBirthDate(new Date());
        p.setWallet(10000.088899);

        PersonVO pvo = Person2PersonVOMapper.MAPPER.fromPerson(p);

        println(p);
        println(pvo);
    }

    @Test
    public void person2PersonVOReverse() {
        PersonVO pv = new PersonVO();
        pv.setName("p1");
        pv.setAge(10);
        pv.setBirth("20181007 16:00:00");
        pv.setWallet("10000.0888");

        Person p = Person2PersonVOMapper.MAPPER.fromPersonVO(pv);

        println(pv);
        println(p);
    }

    @Test
    public void person2PersonVOs() {
        Person p1 = new Person();
        p1.setName("p1");
        p1.setAge(10);
        p1.setBirthDate(new Date());
        p1.setWallet(10000.088899);

        Person p2 = new Person();
        p2.setName("p2");
        p2.setAge(20);
        p2.setBirthDate(new Date());
        p2.setWallet(20000.088899);

        List<PersonVO> voList = Person2PersonVOMapper.MAPPER.fromPersonList(Arrays.asList(p1, p2));
        println(voList);
    }

    @Test
    public void fromPersonVOList() {
        PersonVO pv1 = new PersonVO();
        pv1.setName("p1");
        pv1.setAge(10);
        pv1.setBirth("20181007 16:00:00");
        pv1.setWallet("10000.0888");

        PersonVO pv2 = new PersonVO();
        pv2.setName("p2");
        pv2.setAge(10);
        pv2.setBirth("20181107 16:00:00");
        pv2.setWallet("20000.0888");

        List<Person> personList = Person2PersonVOMapper.MAPPER.fromPersonVOList(Arrays.asList(pv1, pv2));
        println(personList);
    }
}