package com.whu.sres.lhw.tools.spi;

import com.google.auto.service.AutoService;

/**
 * Description:
 * Created by lvhw on 2018/10/23 23:20.
 */
@AutoService(IMyServiceLoader.class)
public class MyServiceLoaderImpl2 implements IMyServiceLoader {
    @Override
    public String sayHello() {
        return "hello2";
    }

    @Override
    public String getName() {
        return "name2";
    }
}
