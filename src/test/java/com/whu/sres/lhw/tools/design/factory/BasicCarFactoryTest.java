package com.whu.sres.lhw.tools.design.factory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created by lvhw on 2018/10/5 18:59.
 */
public class BasicCarFactoryTest {

    @Test
    public void createCarNormal() {
        Car car = BasicCarFactory.createCar(FordCar.class);
        car.print();
    }

    @Test
    public void createCarBoarder() {
        // 边界值 Car.class
        Car car = BasicCarFactory.createCar(Car.class);
        car.print();
    }
}