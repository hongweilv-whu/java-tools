package com.whu.sres.lhw.tools.design.singleton;

import javax.sound.midi.Soundbank;

/**
 * Description:单例模式-懒汉式，内部类实现方式
 * Created by lvhw on 2018/10/6 12:04.
 */
public final class LazyInnerClassSingleton {
    private LazyInnerClassSingleton() {
    }

    public static LazyInnerClassSingleton getInstance() {
        return SingletonHolder.HOLDER;
    }

    public void print() {
        System.out.println("lazy inner class singleton.");
    }

    private static class SingletonHolder {
        static final LazyInnerClassSingleton HOLDER = new LazyInnerClassSingleton();
    }
}
