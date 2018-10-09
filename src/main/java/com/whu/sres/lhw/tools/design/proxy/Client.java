package com.whu.sres.lhw.tools.design.proxy;

/**
 * Description:
 * Created by lvhw on 2018/10/8 22:03.
 */
public class Client {
    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();
        Object proxy = new DynamicProxy().bind(realSubject);
        ((Subject1)proxy).f1();
        System.out.println(((Subject1)proxy).f2());
        System.out.println(((Subject2)proxy).f3());
    }
}
