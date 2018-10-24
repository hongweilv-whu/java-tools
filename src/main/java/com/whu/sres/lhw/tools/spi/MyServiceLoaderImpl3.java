package com.whu.sres.lhw.tools.spi;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Created by lvhw on 2018/10/23 23:20.
 */
//@AutoService(IMyServiceLoader.class)
public class MyServiceLoaderImpl3 implements IMyServiceLoader {
    @Override
    public String sayHello() {

        return "hello3";
    }

    @Override
    public String getName() {
        return "name3";
    }
}
