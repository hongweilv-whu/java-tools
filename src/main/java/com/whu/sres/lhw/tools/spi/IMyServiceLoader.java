package com.whu.sres.lhw.tools.spi;

/**
 * Description:
 * 1.在idea环境下，resources/META-INF/services/xxxx文件会被自动拷贝到build目录，target/class下
 * 2.使用Google auto-service的@AutoService注解，可省去编写services下的文件的步骤
 *
 * Created by lvhw on 2018/10/23 23:19.
 */
public interface IMyServiceLoader {

    String sayHello();

    String getName();
}
