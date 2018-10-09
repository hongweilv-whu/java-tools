package com.whu.sres.lhw.tools.design.singleton;

/**
 * Description:单例模式-懒汉式，双重加锁校验synchronized实现线程安全
 * Created by lvhw on 2018/10/6 11:54.
 */
public final class LazyLockSingleton {

    private static LazyLockSingleton singleton;

    private LazyLockSingleton() {
    }

    public static LazyLockSingleton getInstance() {

        // 双重加锁校验
        if (null == singleton) {
            synchronized (LazyLockSingleton.class) {
                if (null == singleton) {
                    singleton = new LazyLockSingleton();
                }
            }
        }
        return singleton;
    }

    public void print() {
        System.out.println("lazy lock singleton.");
    }
}
