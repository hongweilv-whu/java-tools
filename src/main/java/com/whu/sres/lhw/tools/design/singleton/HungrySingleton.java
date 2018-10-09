package com.whu.sres.lhw.tools.design.singleton;

/**
 * Description: 单例模式-饿汉式实现
 * Created by lvhw on 2018/10/6 11:45.
 */
public final class HungrySingleton {

    private static final HungrySingleton SINGLE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return SINGLE;
    }

    public void print() {
        System.out.println("hungry singleton.");
    }
}
