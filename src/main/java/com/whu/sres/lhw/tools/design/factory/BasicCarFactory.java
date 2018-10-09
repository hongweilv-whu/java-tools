package com.whu.sres.lhw.tools.design.factory;

/**
 * Description:
 * Created by lvhw on 2018/10/5 18:56.
 */
public final class BasicCarFactory {
    private BasicCarFactory() {
    }

    public static Car createCar(Class<? extends Car> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
