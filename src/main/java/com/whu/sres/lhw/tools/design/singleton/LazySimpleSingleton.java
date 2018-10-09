package com.whu.sres.lhw.tools.design.singleton;

/**
 * Description: 单例模式-懒汉式，简单懒汉式，synchronized方法实现线程安全
 * Created by lvhw on 2018/10/6 11:49.
 */
public final class LazySimpleSingleton {
    private static LazySimpleSingleton singleton;

    private LazySimpleSingleton() {
    }

    public static synchronized LazySimpleSingleton getInstance() {
        if (null == singleton) {
            singleton = new LazySimpleSingleton();
        }
        return singleton;
    }

    public void print() {
        System.out.println("lazy simple singleton.");
    }
}
