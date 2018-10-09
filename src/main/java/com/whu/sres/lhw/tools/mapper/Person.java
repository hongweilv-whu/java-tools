package com.whu.sres.lhw.tools.mapper;

import lombok.Data;

import java.util.Date;

/**
 * Description:
 * Created by lvhw on 2018/10/6 18:07.
 */
@Data
class Person {
    private String name;

    private Integer age;

    private Date birthDate;

    private Double wallet;
}
