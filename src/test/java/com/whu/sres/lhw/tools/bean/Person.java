package com.whu.sres.lhw.tools.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * Created by lvhw on 2018/10/6 17:32.
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name;

    private int id;

    private transient String passWord;

    private Career career;
}
