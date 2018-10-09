package com.whu.sres.lhw.tools.design.proxy;

/**
 * Description:
 * Created by lvhw on 2018/10/8 11:33.
 */
public class RealSubject implements Subject1, Subject2 {
    @Override
    public void f1() {
        System.out.println("f1 exec.");
    }

    @Override
    public String f2() {
        return "f2";
    }

    @Override
    public String f3() {
        return "f3";
    }
}
