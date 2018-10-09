package com.whu.sres.lhw.tools;

import com.alibaba.fastjson.JSON;

/**
 * Desc: JSON工具类，封装了fastjson
 * Created by lvhongwei on 2018/9/14.
 */
public final class JSONTools {

    private JSONTools() {
    }

    /**
     * 转成JSON，美化输出。该方法常用语日志的格式化输出中
     *  obj是String类型，
     *  且不满足json格式时，方法抛出parse异常
     * @param obj   待输出对象
     */
    public static String prettyFormat(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSON.toJSONString(JSON.parseObject(obj.toString()), true);
    }
}
