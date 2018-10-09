package com.whu.sres.lhw.tools.design.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created by lvhw on 2018/10/6 11:47.
 */
public class HungrySingletonTest {

    @Test
    public void print() {
        HungrySingleton singleton = HungrySingleton.getInstance();
        singleton.print();
    }
}