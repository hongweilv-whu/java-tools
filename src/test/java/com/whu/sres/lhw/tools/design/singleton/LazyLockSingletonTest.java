package com.whu.sres.lhw.tools.design.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created by lvhw on 2018/10/6 14:27.
 */
public class LazyLockSingletonTest {

    @Test
    public void print() {
        LazyLockSingleton singleton = LazyLockSingleton.getInstance();
        singleton.print();
    }
}