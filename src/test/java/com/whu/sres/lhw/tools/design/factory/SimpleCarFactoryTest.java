package com.whu.sres.lhw.tools.design.factory;

import org.junit.Test;

/**
 * Description:
 * Created by lvhw on 2018/10/5 18:21.
 */
public class SimpleCarFactoryTest {

    @Test
    public void createCar() {
        Car car = SimpleCarFactory.FordCar.create();
        car.print();

        Car car2 = SimpleCarFactory.BuickCar.create();
        car2.print();
    }
}