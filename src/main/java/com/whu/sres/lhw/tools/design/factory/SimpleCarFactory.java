package com.whu.sres.lhw.tools.design.factory;

/**
 * Description: 枚举简单工厂方法实现
 * Created by lvhw on 2018/10/5 18:19.
 */
public enum SimpleCarFactory {
    FordCar {
        @Override
        public Car create() {
            return new FordCar();
        }
    },
    BuickCar {
        @Override
        public Car create() {
            return new BuickCar();
        }
    };

    public abstract Car create();
}
