package org.tank.tool.core.utils;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
  * @description 时间工具类
  * @author lbx
  * @date 2019/11/30 15:27
  * @version 1.0.0
 **/
public class DateUtil extends cn.hutool.core.date.DateUtil {

    /**支持时间格式*/
    public final static String[] SUPPORTED_FORMATS	= {
            "yyyy-MM-dd","yyyy-MM-dd HH:mm:ss","HH:mm:ss"};

    /**日期时间格式*/
    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**日期格式*/
    public static final String PATTERN_DATE = "yyyy-MM-dd";

    /**时间格式*/
    public static final String PATTERN_TIME = "HH:mm:ss";

    /**
     * 老 date 格式化 弃用
     * SimpleDateFormat 线程不安全
     */
    public static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat(PATTERN_DATETIME);
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(PATTERN_DATE);
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(PATTERN_TIME);
    /**
     * java 8 时间格式化
     * DateTimeFormatter 线程安全
     */
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATETIME);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATE);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_TIME);

    /**
     * 获取当期日期时间，日期时间格式： yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getCurrentDateTime() {
        return DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 获取当期日期，日期格式： yyyy-MM-dd
     * @return String
     */
    public static String getCurrentDate() {
        return DATE_FORMATTER.format(LocalDate.now());
    }

    /**
     * 获取当期时间，时间格式：HH:mm:ss
     * @return String
     */
    public static String getCurrentTime() {
        return TIME_FORMATTER.format(LocalTime.now());
    }

    /**
     * 获取当期时间，时间格式：format
     * @return String
     */
    public static String getCurrentByFormat(@NotNull String format) {
       return  DateTimeFormatter.ofPattern(format).format(LocalDateTime.now());
    }

    /**
     * java8 日期时间格式化
     *
     * @param temporal 时间
     * @return 格式化后的时间
     */
    public static String formatDateTime(TemporalAccessor temporal) {
        return DATETIME_FORMATTER.format(temporal);
    }

    /**
     * java8 日期时间格式化
     *
     * @param temporal 时间
     * @return 格式化后的时间
     */
    public static String formatDate(TemporalAccessor temporal) {
        return DATE_FORMATTER.format(temporal);
    }

    /**
     * java8 时间格式化
     *
     * @param temporal 时间
     * @return 格式化后的时间
     */
    public static String formatTime(TemporalAccessor temporal) {
        return TIME_FORMATTER.format(temporal);
    }

    /**
     * java8 日期格式化
     *
     * @param temporal 时间
     * @param pattern  表达式
     * @return 格式化后的时间
     */
    public static String format(TemporalAccessor temporal, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(temporal);
    }





    public static void main(String[] args) {
        System.out.println(DateUtil.getCurrentDateTime());
    }
}
