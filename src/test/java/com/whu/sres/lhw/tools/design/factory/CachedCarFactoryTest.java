package com.whu.sres.lhw.tools.design.factory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created by lvhw on 2018/10/5 18:34.
 */
public class CachedCarFactoryTest {

    @Test
    public void create() {
        Car ford1 = CachedCarFactory.FordCar.create();
        Car ford2 = CachedCarFactory.FordCar.create();
        Car buick1 = CachedCarFactory.BuickCar.create();
        Car buick2 = CachedCarFactory.BuickCar.create();
        ford1.print();
        ford2.print();
        buick1.print();
        buick2.print();

        System.out.println(ford1);
        System.out.println(ford2);
        System.out.println(buick1);
        System.out.println(buick2);

    }

    @Test
    public void testCreateByNameNormal() {
        String carName = "fordcar";
        Car car = CachedCarFactory.getByName(carName).create();
        car.print();
    }

    @Test
    public void testCreateByNameBoarder() {
        String carName = "buickcarcar";
        Car car = CachedCarFactory.getByName(carName).create();
        car.print();
    }
}