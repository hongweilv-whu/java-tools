package com.whu.sres.lhw.tools.design.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created by lvhw on 2018/10/6 11:53.
 */
public class LazySimpleSingletonTest {

    @Test
    public void print() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        singleton.print();

    }
}