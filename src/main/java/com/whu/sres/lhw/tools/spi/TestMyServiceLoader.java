package com.whu.sres.lhw.tools.spi;

import java.util.ServiceLoader;

/**
 * Description:
 * Created by lvhw on 2018/10/23 23:21.
 */
public class TestMyServiceLoader {
    public static void main(String[] args) {
        ServiceLoader<IMyServiceLoader> loader = ServiceLoader.load(IMyServiceLoader.class);
        for (IMyServiceLoader iMyServiceLoader : loader) {
            System.out.println(iMyServiceLoader.sayHello());
            System.out.println(iMyServiceLoader.getName());
        }
    }
}
