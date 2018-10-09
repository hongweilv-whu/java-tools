package com.whu.sres.lhw.tools;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Desc: 数字、数学工具类
 * Created by lvhongwei on 2018/4/14.
 */
public final class MathTools {

    private MathTools() {
    }

    /**
     * 判定字符串是否是整数
     * @param str 目标字符串
     */
    public static boolean isIntNumber(final String str) {
        return NumberUtils.isNumber(str) && !StringUtils.containsIgnoreCase(str, ".");
    }

    /**
     * 判定字符串是否是小数
     * @param str 目标字符串
     */
    public static boolean isFloatNumber(final String str) {
        return NumberUtils.isNumber(str) && StringUtils.containsIgnoreCase(str, ".");
    }
}
