package com.whu.sres.lhw.tools;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * Created by lvhw on 2018/10/2 21:06.
 */

public class BaseTest {

    protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    protected void println(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }
}
