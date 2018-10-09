package com.whu.sres.lhw.tools.design.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created by lvhw on 2018/10/6 14:28.
 */
public class LazyInnerClassSingletonTest {

    @Test
    public void print() {
        LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
        singleton.print();
    }
}