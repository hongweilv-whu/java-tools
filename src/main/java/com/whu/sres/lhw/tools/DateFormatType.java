package com.whu.sres.lhw.tools;

/**
 * Desc:日期格式枚举类
 * Created by lvhongwei on 2018/4/26.
 */
public enum DateFormatType {
    YYYY(1, "yyyy"),
    YYYY_MM(2, "yyyyMM"),
    YYYY_MM_DD(3, "yyyyMMdd"),
    YYYY_MM_DD_HH(4, "yyyyMMddHH"),
    YYYY_MM_DD_HH_MM(5, "yyyyMMddHHmm"),
    YYYY_MM_DD_HH_MM_SS(6, "yyyyMMddHHmmss"),
    ;

    private int code;
    private String value;

    DateFormatType(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
