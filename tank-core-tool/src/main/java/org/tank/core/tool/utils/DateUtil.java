package org.tank.core.tool.utils;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
  * @description 时间工具类
  * @author lbx
  * @date 2019/11/30 15:27
  * @version 1.0.0
 **/
public class DateUtil  {

    /**日期时间格式*/
    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**日期时间格式-中文*/
    public static final String PATTERN_DATETIME_CH = "yyyy年MM月dd日HH时mm分ss秒";


    /**日期格式*/
    public static final String PATTERN_DATE = "yyyy-MM-dd";

    /**日期格式-中文*/
    public static final String PATTERN_DATECH = "yyyy年MM月dd日";

    /**日期格式*/
    public static final String PATTERN_SHORT_DATE = "yyyyMMdd";

    /**日期格式*/
    public static final String PATTERN_YEAR_MONTH = "yyyy-MM";

    /**日期格式-中文*/
    public static final String PATTERN_YEAR_MONTH_CH = "yyyy年MM月";

    /**时间格式*/
    public static final String PATTERN_TIME = "HH:mm:ss";

    /**时间格式-中文*/
    public static final String PATTERN_TIME_CH = "HH时mm分ss秒";

    /**时间格式*/
    public static final String PATTERN_TIME2 = "HHmmss";

    /**时间格式,包含毫秒*/
    public static final String PATTERN_LONG_DATETIME = "yyyyMMddHHmmssSSS";

    /**时间格式,包含毫秒*/
    public static final String PATTERN_LONG_DATETIME2 = "yyyy-MM-dd HH:mm:ss SSS";

    /**
     * 00:00:00
     */
    public static final String	BEGIN_TIME = " 00:00:00";
    /**
     * 23:59:59
     */
    public static final String	END_TIME = " 23:59:59";

    /**
     * java 8 时间格式化
     * DateTimeFormatter 线程安全
     */
    /**格式: yyyy-MM-dd HH:mm:ss*/
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATETIME);

    /**格式: yyyy-MM-dd*/
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATE);

    /**格式: HH:mm:ss*/
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_TIME);

    /**格式: HHmmss*/
    public static final DateTimeFormatter TIME_FORMATTER2 = DateTimeFormatter.ofPattern(DateUtil.PATTERN_TIME2);

    /**格式: yyyy-MM*/
    public static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_YEAR_MONTH);

    /**格式: yyyyMMdd*/
    public static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_SHORT_DATE);

    /**格式: yyyyMMddHHmmssSSS*/
    public static final DateTimeFormatter LONG_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtil.PATTERN_LONG_DATETIME);

    /**格式: yyyy-MM-dd HH:mm:ss SSS*/
    public static final DateTimeFormatter LONG_DATETIME_FORMATTER2 = DateTimeFormatter.ofPattern(DateUtil.PATTERN_LONG_DATETIME2);


    /**
     * 获取当期日期时间，日期时间格式： yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getCurrentDateTime() {
        return DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 获取当期日期时间，日期时间格式： yyyy年MM月dd日HH时mm分ss秒
     * @return String
     */
    public static String getCurrentDateTimeCH() {
        return DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATETIME_CH).format(LocalDateTime.now());
    }

    /**
     * 获取当期日期，日期格式： yyyy-MM-dd
     * @return String
     */
    public static String getCurrentDate() {
        return DATE_FORMATTER.format(LocalDate.now());
    }

    /**
     * 获取当期日期，日期格式： yyyy年MM月dd日
     * @return String
     */
    public static String getCurrentDateCH() {
        return DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATECH).format(LocalDateTime.now());
    }

    /**
     * 获取当期时间,时间格式：yyyyMMdd
     */
    public static String getCurrentShortDate() {
        return LocalDate.now().format(SHORT_DATE_FORMATTER);
    }

    /**
     * 获取当期时间,时间格式：yyyyMM
     */
    public static String getCurrentYearMonth() {
        return LocalDate.now().format(YEAR_MONTH_FORMATTER);
    }

    /**
     * 获取当期时间,时间格式：yyyy年MM月
     */
    public static String getCurrentYearMonthCH() {
        return DateTimeFormatter.ofPattern(DateUtil.PATTERN_YEAR_MONTH_CH).format(LocalDateTime.now());
    }

    /**
     * 获取当期时间，时间格式：HH:mm:ss
     * @return String
     */
    public static String getCurrentTime() {
        return TIME_FORMATTER.format(LocalTime.now());
    }

    /**
     * 获取当期时间，时间格式：HH时mm分ss秒
     * @return String
     */
    public static String getCurrentTimeCH() {
        return DateTimeFormatter.ofPattern(DateUtil.PATTERN_TIME_CH).format(LocalDateTime.now());
    }

    /**
     * 获取当期时间，时间格式：HHmmss
     * @return String
     */
    public static String getCurrentTime2() {
        return TIME_FORMATTER2.format(LocalTime.now());
    }

    /**
     * 获取当期时间，时间格式：yyyyMMddHHmmssSSS
     * @return String
     */
    public static String getCurrentLongDateTime() {
        return LONG_DATETIME_FORMATTER.format(LocalTime.now());
    }

    /**
     * 获取当期时间，时间格式：yyyy-MM-dd HH:mm:ss SSS
     * @return String
     */
    public static String getCurrentLongDateTime2() {
        return LONG_DATETIME_FORMATTER2.format(LocalTime.now());
    }

    /**
     * 获取当期时间，时间格式：format
     * @return String
     */
    public static String getCurrentByFormat(@NotNull String pattern) {
       return  DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.now());
    }

    /**
     * 返回当前的日期
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 返回当前日期时间
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * @return 返回当天的起始时间
     */
    public static Date getStartTime() {
        LocalDateTime now = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        return toDate(now);
    }

    /**
     * @return 返回当天的起始时间
     */
    public static String getStartTimeStr() {
        LocalDateTime now = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        return format(now,DateUtil.PATTERN_DATETIME);
    }

    /**
     * @return 返回指定的起始时间
     */
    public static String getStartTimeStr(String dateStr) {
        return dateStr+ BEGIN_TIME;
    }


    /**
     * @return 返回当天的结束时间
     */
    public static Date getEndTime() {
        LocalDateTime now = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999);
        return toDate(now);
    }

    /**
     * @return 返回当天的结束时间
     */
    public static String getEndTimeStr() {
        LocalDateTime now = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999);
        return format(now,DateUtil.PATTERN_DATETIME);
    }

    /**
     * @return 返回指定的结束时间
     */
    public static String getEndTimeStr(String dateStr) {
        return dateStr+END_TIME;
    }

    /**
     * 查询当前年的第一天
     *
     * @param pattern 格式，默认格式yyyy-MM-dd
     * @return 2019-01-01
     */
    public static String getFirstDayOfCurrentYear(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfYear());
        if (StringUtil.isEmpty(pattern)) {
            pattern = DateUtil.PATTERN_DATE;
        }
        return format(localDateTime, pattern);
    }

    /**
     * 查询当前年的第一天
     *
     * @param pattern 格式，默认格式yyyy-MM-dd
     * @return 2019-12-31
     */
    public static String getLastDayOfCurrentYear(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfYear());
        if (StringUtil.isEmpty(pattern)) {
            pattern = DateUtil.PATTERN_DATE;
        }
        return format(localDateTime, pattern);
    }

    /**
     * 查询当前年的第一天
     *
     * @param pattern 格式，默认格式yyyy-MM-dd
     * @return 2019-01-01
     */
    public static String getFirstDayOfCurrentMonth(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
        if (StringUtil.isEmpty(pattern)) {
            pattern = DateUtil.PATTERN_DATE;
        }
        return format(localDateTime, pattern);
    }

    /**
     * 查询当前年的第一天
     *
     * @param pattern 格式，默认格式yyyy-MM-dd
     * @return 2019-12-31
     */
    public static String getLastDayOfCurrentMonth(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
        if (StringUtil.isEmpty(pattern)) {
            pattern = DateUtil.PATTERN_DATE;
        }
        return format(localDateTime, pattern);
    }

    /**
     * 查询当前季度的第一天
     *
     * @param pattern 格式，默认格式yyyy-MM-dd
     * @return 2019-01-01
     */
    public static String getFirstDayOfCurrentQuarter(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int month = getCurrentQuarterMonth(localDateTime);
        if (StringUtil.isEmpty(pattern)) {
            pattern = DateUtil.PATTERN_DATE;
        }
        return format(localDateTime.withMonth(month).with(TemporalAdjusters.firstDayOfMonth()), pattern);
    }

    /**
     * 查询当前季度的最后一天
     *
     * @param pattern 格式，默认格式yyyy-MM-dd
     * @return 2019-12-31
     */
    public static String getLastDayOfCurrentQuarter(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int month = getCurrentQuarterMonth(localDateTime);
        if (StringUtil.isEmpty(pattern)) {
            pattern = DateUtil.PATTERN_DATE;
        }
        return format(localDateTime.withMonth(month+3).with(TemporalAdjusters.lastDayOfMonth()), pattern);
    }

    /**
     * 查询当前季度的月份
     *
     * @param localDateTime
     * @return 月份
     */
    public static int getCurrentQuarterMonth(LocalDateTime localDateTime){
        Month currentMonth = localDateTime.getMonth();
        int month = 0;
        switch (currentMonth){
            case JANUARY:
                month = 1;
                break;
            case FEBRUARY:
                month = 1;
                break;
            case MARCH:
                month = 1;
                break;
            case APRIL:
                month = 4;
                break;
            case MAY:
                month = 4;
                break;
            case JUNE:
                month = 4;
                break;
            case JULY:
                month = 7;
                break;
            case AUGUST:
                month = 7;
                break;
            case SEPTEMBER:
                month = 7;
                break;
            case OCTOBER:
                month = 9;
                break;
            case NOVEMBER:
                month = 9;
                break;
            case DECEMBER:
                month = 9;
                break;
            default:
                month = 0;
                break;
        }
        return month;
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

    /**
     * 日期格式化
     *
     * @param date    时间
     * @param pattern 表达式
     * @return 格式化后的时间
     */
    public static String format(Date date, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(fromDate(date));
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr 时间字符串
     * @param pattern 表达式
     * @return 时间
     */
    public static Date parse(String dateStr, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 时间转 Instant
     *
     * @param dateTime 时间
     * @return Instant
     */
    public static Instant toInstant(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant();
    }


    /**
     * 转换成 date
     *
     * @param dateTime LocalDateTime
     * @return Date
     */
    public static Date toDate(LocalDateTime dateTime) {
        return Date.from(DateUtil.toInstant(dateTime));
    }
    /**
     * 转换成 date
     *
     * @param localDate LocalDate
     * @return Date
     */
    public static Date toDate(final LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts local date time to Calendar.
     */
    public static Calendar toCalendar(final LocalDateTime localDateTime) {
        return GregorianCalendar.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()));
    }

    /**
     * localDateTime 转换成毫秒数
     *
     * @param localDateTime LocalDateTime
     * @return long
     */
    public static long toMilliseconds(final LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * localDate 转换成毫秒数
     *
     * @param localDate LocalDate
     * @return long
     */
    public static long toMilliseconds(LocalDate localDate) {
        return toMilliseconds(localDate.atStartOfDay());
    }

    /**
     * 转换成java8 时间
     *
     * @param calendar 日历
     * @return LocalDateTime
     */
    public static LocalDateTime fromCalendar(final Calendar calendar) {
        TimeZone tz = calendar.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        return LocalDateTime.ofInstant(calendar.toInstant(), zid);
    }

    /**
     * 转换成java8 时间
     *
     * @param instant Instant
     * @return LocalDateTime
     */
    public static LocalDateTime fromInstant(final Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 转换成java8 时间
     *
     * @param date Date
     * @return LocalDateTime
     */
    public static LocalDateTime fromDate(final Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 转换成java8 时间
     *
     * @param milliseconds 毫秒数
     * @return LocalDateTime
     */
    public static LocalDateTime fromMilliseconds(final long milliseconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault());
    }

    /**
     * 比较2个时间差，跨度比较小
     *
     * @param startInclusive 开始时间
     * @param endExclusive   结束时间
     * @return 时间间隔
     */
    public static Duration between(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive);
    }

    /**
     * 比较2个时间差，跨度比较大，年月日为单位
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 时间间隔
     */
    public static Period between(LocalDate startDate, LocalDate endDate) {
        return Period.between(startDate, endDate);
    }

    /**
     * 比较2个 时间差
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 时间间隔
     */
    public static Duration between(Date startDate, Date endDate) {
        return Duration.between(startDate.toInstant(), endDate.toInstant());
    }


    /**
     * 日期相隔秒
     */
    public static long periodHours(LocalDateTime startDateTime,LocalDateTime endDateTime){
        return Duration.between(startDateTime, endDateTime).get(ChronoUnit.SECONDS);
    }

    /**
     * 日期相隔天数
     */
    public static long periodDays(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

    /**
     * 日期相隔周数
     */
    public static long periodWeeks(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.WEEKS);
    }

    /**
     * 日期相隔月数
     */
    public static long periodMonths(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.MONTHS);
    }

    /**
     * 日期相隔年数
     */
    public static long periodYears(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.YEARS);
    }

    /**
     * 将秒数转换为日时分秒
     *
     * @param second 秒数
     * @return 时间
     */
    public static String secondToTime(Long second) {
        // 判断是否为空
        if (second == null || second == 0L) {
            return StringPool.EMPTY;
        }
        //转换天数
        long days = second / 86400;
        //剩余秒数
        second = second % 86400;
        //转换小时
        long hours = second / 3600;
        //剩余秒数
        second = second % 3600;
        //转换分钟
        long minutes = second / 60;
        //剩余秒数
        second = second % 60;
        if (days > 0) {
            return StringUtil.format("{}天{}小时{}分{}秒", days, hours, minutes, second);
        } else {
            return StringUtil.format("{}小时{}分{}秒", hours, minutes, second);
        }
    }


    /**
     * 设置日期属性
     *
     * @param date          时间
     * @param calendarField 更改的属性
     * @param amount        更改数，-1表示减少
     * @return 设置后的时间
     */
    private static Date set(Date date, int calendarField, int amount) {
        Assert.notNull(date, "The date must not be null");
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }


    /**
     * 添加年
     *
     * @param date       时间
     * @param yearsToAdd 添加的年数
     * @return 设置后的时间
     */
    public static Date plusYears(Date date, int yearsToAdd) {
        return DateUtil.set(date, Calendar.YEAR, yearsToAdd);
    }

    /**
     * 添加月
     *
     * @param date        时间
     * @param monthsToAdd 添加的月数
     * @return 设置后的时间
     */
    public static Date plusMonths(Date date, int monthsToAdd) {
        return DateUtil.set(date, Calendar.MONTH, monthsToAdd);
    }

    /**
     * 添加周
     *
     * @param date       时间
     * @param weeksToAdd 添加的周数
     * @return 设置后的时间
     */
    public static Date plusWeeks(Date date, int weeksToAdd) {
        return DateUtil.plus(date, Period.ofWeeks(weeksToAdd));
    }

    /**
     * 添加天
     *
     * @param date      时间
     * @param daysToAdd 添加的天数
     * @return 设置后的时间
     */
    public static Date plusDays(Date date, long daysToAdd) {
        return DateUtil.plus(date, Duration.ofDays(daysToAdd));
    }

    /**
     * 添加小时
     *
     * @param date       时间
     * @param hoursToAdd 添加的小时数
     * @return 设置后的时间
     */
    public static Date plusHours(Date date, long hoursToAdd) {
        return DateUtil.plus(date, Duration.ofHours(hoursToAdd));
    }

    /**
     * 添加分钟
     *
     * @param date         时间
     * @param minutesToAdd 添加的分钟数
     * @return 设置后的时间
     */
    public static Date plusMinutes(Date date, long minutesToAdd) {
        return DateUtil.plus(date, Duration.ofMinutes(minutesToAdd));
    }

    /**
     * 添加秒
     *
     * @param date         时间
     * @param secondsToAdd 添加的秒数
     * @return 设置后的时间
     */
    public static Date plusSeconds(Date date, long secondsToAdd) {
        return DateUtil.plus(date, Duration.ofSeconds(secondsToAdd));
    }

    /**
     * 添加毫秒
     *
     * @param date        时间
     * @param millisToAdd 添加的毫秒数
     * @return 设置后的时间
     */
    public static Date plusMillis(Date date, long millisToAdd) {
        return DateUtil.plus(date, Duration.ofMillis(millisToAdd));
    }

    /**
     * 添加纳秒
     *
     * @param date       时间
     * @param nanosToAdd 添加的纳秒数
     * @return 设置后的时间
     */
    public static Date plusNanos(Date date, long nanosToAdd) {
        return DateUtil.plus(date, Duration.ofNanos(nanosToAdd));
    }

    /**
     * 日期添加时间量
     *
     * @param date   时间
     * @param amount 时间量
     * @return 设置后的时间
     */
    public static Date plus(Date date, TemporalAmount amount) {
        Instant instant = date.toInstant();
        return Date.from(instant.plus(amount));
    }

    /**
     * 减少年
     *
     * @param date  时间
     * @param years 减少的年数
     * @return 设置后的时间
     */
    public static Date minusYears(Date date, int years) {
        return DateUtil.set(date, Calendar.YEAR, -years);
    }

    /**
     * 减少月
     *
     * @param date   时间
     * @param months 减少的月数
     * @return 设置后的时间
     */
    public static Date minusMonths(Date date, int months) {
        return DateUtil.set(date, Calendar.MONTH, -months);
    }

    /**
     * 减少周
     *
     * @param date  时间
     * @param weeks 减少的周数
     * @return 设置后的时间
     */
    public static Date minusWeeks(Date date, int weeks) {
        return DateUtil.minus(date, Period.ofWeeks(weeks));
    }

    /**
     * 减少天
     *
     * @param date 时间
     * @param days 减少的天数
     * @return 设置后的时间
     */
    public static Date minusDays(Date date, long days) {
        return DateUtil.minus(date, Duration.ofDays(days));
    }

    /**
     * 减少小时
     *
     * @param date  时间
     * @param hours 减少的小时数
     * @return 设置后的时间
     */
    public static Date minusHours(Date date, long hours) {
        return DateUtil.minus(date, Duration.ofHours(hours));
    }

    /**
     * 减少分钟
     *
     * @param date    时间
     * @param minutes 减少的分钟数
     * @return 设置后的时间
     */
    public static Date minusMinutes(Date date, long minutes) {
        return DateUtil.minus(date, Duration.ofMinutes(minutes));
    }

    /**
     * 减少秒
     *
     * @param date    时间
     * @param seconds 减少的秒数
     * @return 设置后的时间
     */
    public static Date minusSeconds(Date date, long seconds) {
        return DateUtil.minus(date, Duration.ofSeconds(seconds));
    }

    /**
     * 减少毫秒
     *
     * @param date   时间
     * @param millis 减少的毫秒数
     * @return 设置后的时间
     */
    public static Date minusMillis(Date date, long millis) {
        return DateUtil.minus(date, Duration.ofMillis(millis));
    }

    /**
     * 减少纳秒
     *
     * @param date  时间
     * @param nanos 减少的纳秒数
     * @return 设置后的时间
     */
    public static Date minusNanos(Date date, long nanos) {
        return DateUtil.minus(date, Duration.ofNanos(nanos));
    }

    /**
     * 日期减少时间量
     *
     * @param date   时间
     * @param amount 时间量
     * @return 设置后的时间
     */
    public static Date minus(Date date, TemporalAmount amount) {
        Instant instant = date.toInstant();
        return Date.from(instant.minus(amount));
    }

    /**
     * 判断是否为闰年
     */
    public static boolean isLeapYear(LocalDate localDate){
        return localDate.isLeapYear();
    }

    /**
     * 是否当天
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }




    public static void main(String[] args) {
        System.out.println(LocalDate.now().getMonthValue());
        System.out.println(DateUtil.getLastDayOfCurrentQuarter(null));
    }
}
