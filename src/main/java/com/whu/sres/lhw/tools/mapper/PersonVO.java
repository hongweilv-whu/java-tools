package com.whu.sres.lhw.tools.mapper;

import lombok.Data;

import java.util.Date;

/**
 * Description:
 * Created by lvhw on 2018/10/6 18:08.
 */
@Data
class PersonVO {
    private String name;

    private Integer age;

    /** 与po对象属性名不一致 */
    private String birth;

    private String wallet;

    private String birthFormat;
}
