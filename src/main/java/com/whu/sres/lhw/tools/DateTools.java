package com.whu.sres.lhw.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Desc:
 * Created by lvhongwei on 2018/4/25.
 */
public final class DateTools {

    private DateTools() {
    }

    /**
     * 按默认格式yyyyMMdd，格式化Date对象
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatType.YYYY_MM_DD.getValue());
        return sdf.format(date);
    }

    /**
     * 按指定格式，格式化Date对象
     * @param date   日期对象
     * @param format 格式
     */
    public static String formatDate(Date date, DateFormatType format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.getValue());
        return sdf.format(date);
    }

    /**
     * 按指定格式，格式化时间戳（13位）
     * @param time    时间戳
     * @param format  格式
     */
    public static String formatDateFromTime(Long time, DateFormatType format) {
        return formatDate(new Date(time), format);
    }

    /**
     * 按默认格式yyyyMMdd，格式化时间戳（13位）
     * @param time  时间戳
     */
    public static String formatDateFromTime(Long time) {
        return formatDate(new Date(time));
    }

    /**
     * 按指定格式，格式化unix时间戳（10位）
     * @param unixTime 时间戳
     * @param format   格式
     */
    public static String formatDateFromUnixTime(Long unixTime, DateFormatType format) {
        return formatDateFromTime(unixTime * 1000L, format);
    }

    /**
     * 按默认格式yyyyMMdd，格式化unix时间戳（10位）
     * @param unixTime  时间戳
     */
    public static String formatDateFromUnixTime(Long unixTime) {
        return formatDateFromTime(unixTime * 1000L);
    }

    /**
     * 按默认格式yyyyMMdd，解析得到Date对象
     * @param dateStr   日期字符串
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, DateFormatType.YYYY_MM_DD);
    }

    /**
     * 按指定格式，解析得到Date对象
     * @param dateStr   日期字符串
     * @param format    格式
     */
    public static Date parseDate(String dateStr, DateFormatType format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.getValue());

        // 字符串与格式是否匹配的验证
        if (StringTools.length(dateStr) != StringTools.length(format.getValue())){
            throw new IllegalArgumentException("date string length is not equal the format string's, refuse parse.");
        }
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("parse date exception.", e);
        }
    }

    /**
     * 基于基准日期，计算指定间距的新日期
     * @param date      基准日期
     * @param distance  日期间距，可正可负
     */
    public static Date addDays(Date date, int distance) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, distance);
        return calendar.getTime();
    }

    /**
     * 基于基准日期字符串，计算指定间距的新日期
     * @param dateStr   基准日期字符串，yyyyMMdd格式
     * @param distance  日期间距，可正可负
     */
    public static Date addDays(String dateStr, int distance) {
        return addDays(parseDate(dateStr), distance);
    }

    /**
     * 基于基准日期字符串和格式，计算指定间距的新日期
     * @param dateStr   基准日期字符串
     * @param format    日期格式
     * @param distance  日期间距，可正可负
     */
    public static Date addDays(String dateStr, DateFormatType format, int distance) {
        return addDays(parseDate(dateStr, format), distance);
    }
}
