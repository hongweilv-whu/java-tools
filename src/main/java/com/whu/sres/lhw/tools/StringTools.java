package com.whu.sres.lhw.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Desc: 字符串工具类，默认采用common-lang3实现
 *
 * Created by lvhongwei on 2018/4/14.
 */
public final class StringTools {

    private StringTools() {
    }

    /**
     * null和""都是empty, " "不是empty
     */
    public static boolean isEmpty(CharSequence cs) {
        return StringUtils.isEmpty(cs);
    }

    /**
     * null和""和" "都是blank
     */
    public static boolean isBlank(CharSequence cs) {
        return StringUtils.isBlank(cs);
    }

    /**
     * 判定字符串是否是数字（正负整数，正负小数），不要使用StringUtils.isNumeric();
     */
    public static boolean isNumber(String str) {
        // FIXME:数字前面带+的数字会被误判问题
        return NumberUtils.isNumber(str);
    }

    /**
     * 字符串长度
     */
    public static int length(CharSequence cs) {
        return StringUtils.length(cs);
    }

    public static List<String> split(String str, String separatorChars) {
        if (null == str) {
            return Collections.emptyList();
        }
        String[] parts = StringUtils.split(str, separatorChars);
        return Arrays.asList(parts);
    }

    /**
     * 字符串解码
     * @param str        原始字符串
     * @param encodeName 编码名称
     */
    public static String decode(String str, String encodeName) {
        try {
            return URLDecoder.decode(str, encodeName);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * utf8解码
     * @param str 原始字符串
     */
    public static String utf8Decode(String str) {
        return decode(str, "utf-8");
    }

    /**
     * 字符串编码
     * @param str        原始字符串
     * @param encodeName 编码名称
     * @return           编码后字符串
     */
    public static String encode(String str, String encodeName) {
        try {
            return URLEncoder.encode(str, encodeName);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * utf8编码
     * @param str   原始字符串
     * @return      编码后字符串
     */
    public static String utf8Encode(String str) {
        return encode(str, "utf-8");
    }
}
