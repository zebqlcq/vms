package com.bonade.visitor.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class DateUtil {


    /**
     * yyMMdd 140925
     */
    public static final String DATE_PATTERN_yyMMdd = "yyMMdd";

    /**
     * yyyyMMdd 20140518
     */
    public static String DATE_PATTERN_yyyyMMdd = "yyyyMMdd";
    /**
     * yyyy
     */
    public static String DATE_PATTERN_yyyy = "yyyy";

    /**
     * yyyy-MM-dd 2014-05-18
     */
    public static String DATE_PATTERN_yyyy_MM_dd = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm:ss 2014-05-18 20:20:20
     */
    public static String DATE_PATTERN_yyyy_MM_dd_HH_MM_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd HH:mm 2014-05-18 20:20
     */
    public static String DATE_PATTERN_yyyy_MM_dd_HH_MM = "yyyy-MM-dd HH:mm";
    
    /**
     * yyyy-MM-dd HH:mm 2014-05-18 20:20
     */
    public static String DATE_PATTERN_HH_MM = "HH:mm";

    /**
     * yyyy-MM-dd_HHmmss_SSS 2015-05-18_20-20-20_123
     */
    public static String DATE_PATTERN_yyyy_MM_dd_HHmmss_SSS = "yyyy-MM-dd_HHmmss_SSS";

    /**
     * yyyyMMddHHmmssS 20150518202020123
     */
    public static String DATE_PATTERN_yyyyMMddHHmmssS = "yyyyMMddHHmmssS";

    /**
     * 一天的开始时间点   00:00:00
     */
    public static String START_TIME = " 00:00:00";
    
    public static String START_TIME_HM = " 00:00";

    /**
     * 一天的结束时间点   23:59:59
     */
    public static String END_TIME = " 23:59:59";
    
    public static String END_TIME_HM = " 23:59";


    public static final Date dateParse(String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.parse(format);
    }

    /**
     * 当天的0时0分0秒0毫秒所在时刻的毫秒数
     *
     * @return
     */
    public static final long millisOfStartOfToday() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime().getTime();
    }

    /**
     * 当前的23时59分59秒999毫秒所在时刻的毫秒数
     *
     * @return
     */
    public static final long millisOfEndOfToday() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime().getTime() - 1;
    }

    /**
     * 获取当前日期 前后多少天的日期
     *
     * @param nowdate
     * @param days    负数向前减多少天  正数向后加多少天
     * @return
     */

    public static String getDate(Date nowdate, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(5, days);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

    }


    public static String getRandomNo() {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN_yyyyMMddHHmmssS);
        return formatter.format(new Date()) + Integer.toString((new Random().nextInt(999)));
    }


    /**
     * 获取当前日期 这周的第一天
     *
     * @return date
     */
    @SuppressWarnings("static-access")
    public static String getWeekHand() {
        SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(cal.DAY_OF_WEEK, cal.MONDAY);
        return simdf.format(cal.getTime());

    }

    /**
     * 根据传入时间获得对应当天的开始时间
     *
     * @param taskCrtDttm
     * @return
     */
    public static Date calculateStartOfDay(Date taskCrtDttm) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_yyyy_MM_dd);
        try {
            String source = sdf.format(taskCrtDttm) + START_TIME;
            sdf.applyPattern(DATE_PATTERN_yyyy_MM_dd_HH_MM_ss);
            return sdf.parse(source);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 根据传入时间获得对应当天的结束时间
     *
     * @param taskCrtDttm
     * @return 如：taskCrtDttm=2014-08-23 11:55:23
     * 则 return 2014-08-23 23:59:59
     */
    public static Date calculateEndOfDay(Date taskCrtDttm) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_yyyy_MM_dd);
        try {

            String source = sdf.format(taskCrtDttm) + END_TIME;
            sdf.applyPattern(DATE_PATTERN_yyyy_MM_dd_HH_MM_ss);
            return sdf.parse(source);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br>
     * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
     *
     * @param time Date 日期<br>
     * @return String 字符串<br>
     */
    public static String getDateToString(Date time) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Time = formatter.format(time);
        return Time;
    }


    /**
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss a'(12小时制)<br>
     * 如Sat May 11 17:23:22 CST 2002 to '2002-05-11 05:23:22 下午'<br>
     *
     * @param time Date 日期<br>
     * @param x    int 任意整数如：1<br>
     * @return String 字符串<br>
     */
    public static String getDateToString(Date time, int x) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
        String date = formatter.format(time);
        return date;
    }

    /**
     * 取系统当前时间:返回只值为如下形式 2002-10-30 20:24:39
     *
     * @return String
     */
    public static String getNow() {
        return getDateToString(new Date());
    }


    /**
     * 获取小时
     *
     * @return
     */
    public static String getHour() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("H");
        String hour = formatter.format(new Date());
        return hour;
    }

    /**
     * 获取当前日日期返回 <return>Day</return>
     */
    public static String getDay() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("d");
        String day = formatter.format(new Date());
        return day;
    }

    /**
     * 获取周
     *
     * @return
     */
    public static String getWeek() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("E");
        String week = formatter.format(new Date());
        return week;
    }

    /**
     * 获取月份
     *
     * @return
     */
    public static String getMonth() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("M");
        String month = formatter.format(new Date());
        return month;
    }

    /**
     * 获取年
     *
     * @return
     */
    public static String getYear() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy");
        String year = formatter.format(new Date());
        return year;
    }


    /**
     * 获取指定时间的那天 00:00:00.000 的时间
     *
     * @param date
     * @return
     */
    public static Date dayBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定时间的那天 23:59:59.999 的时间
     *
     * @param date
     * @return
     */
    public static Date dayEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }


    /**
     * 获取当前日期本月的第几天
     */
    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前日期是本周的第几天 周一是 1 周日返回7
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        boolean isFirstSunday = (calendar.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取周几
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }

        return weekDay;
    }

    /**
     * 获取当前月的最后一天
     */
    public static int getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static String getOrderNo() {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN_yyyyMMddHHmmssS);
        return formatter.format(new Date()) + Integer.toString((new Random().nextInt(999)));
    }

    /**
     * 获得指定日期的前N天 的日期
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayByNum(String specifiedDay, int num) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            c.setTime(date);
        }

        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + num);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }


    /**
     * 获得指定日期的前N天 的日期
     *
     * @param
     * @return
     * @throws Exception
     */
    public static Date getNextDay(Date date, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, count);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }

    public static final Date stringToDate(String date) {
        if (date == null) {
            return null;
        } else {
            String separator = String.valueOf(date.charAt(4));
            String pattern = "yyyyMMdd";
            if (!separator.matches("\\d*")) {
                pattern = "yyyy" + separator + "MM" + separator + "dd";
                if (date.length() < 10) {
                    pattern = "yyyy" + separator + "M" + separator + "d";
                }
            } else if (date.length() < 8) {
                pattern = "yyyyMd";
            }

            pattern = pattern + " HH:mm:ss.SSS";
            pattern = pattern.substring(0, Math.min(pattern.length(), date.length()));

            try {
                return (new SimpleDateFormat(pattern)).parse(date);
            } catch (ParseException var4) {
                return null;
            }
        }
    }

    /**
     * 日期格式
     **/
    public interface DATE_PATTERN {
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYYMMDDHHMMSSS = "yyyyMMddHHmmssS";
        String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
        String YYYY_MM_DD_KK_MM_SS_AM = "yyyy-MM-dd KK:mm:ss a";
        String YYYY_MM_DD_HHMMSS_SSS = "yyyy-MM-dd_HHmmss_SSS";
        String YYYY_MM_DDTHHMMSS_SSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";
        String YYYY_MM_DD_2 = "yyyy/MM/dd";
        String PARSE_PATTERNS[] = {YYYY_MM_DD_HH_MM_SS, YYYYMMDD, YYYY_MM_DD_2, YYYYMMDDHHMMSS,
            YYYY_MM_DD_HH_MM_SS_SSS, YYYY_MM_DDTHHMMSS_SSSZ, YYYYMMDDHHMMSSSSS, YYYY_MM_DD_KK_MM_SS_AM,
            YYYY_MM_DD_HHMMSS_SSS, YYYYMMDDHHMMSSS,};
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static final String format(Object date, String pattern) {
        if (date == null) {
            return null;
        }
        if (pattern == null) {
            return format(date);
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static final String format(Object date) {
        return format(date, DATE_PATTERN.YYYY_MM_DD);
    }

    /**
     * 获取当前日期时间字符串
     *
     * @return
     */
    public static final String getDateTime() {
        return format(new Date(), DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * @throws
     * @Title: string2Date
     * @Description: 字符串传date
     * @param: @param date_str
     * @param: @param format
     * @param: @return
     * @param: @throws ParseException
     * @return: Date
     * @author: lcq
     * @date: 2019年3月21日 上午11:15:17
     * @version 1.0
     */
    public static final Date string2Date(String date_str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @throws
     * @Title: date2LocalDateTime
     * @Description: date转localDateTime
     * @param: @param date
     * @param: @return
     * @param: @throws ParseException
     * @return: LocalDateTime
     * @author: lcq
     * @date: 2019年3月21日 上午11:15:35
     * @version 1.0
     */
    public static final LocalDateTime date2LocalDateTime(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        return localDateTime;
    }


    /**
     * @throws
     * @Title: localDateTime2Date
     * @Description: localDateTime转date
     * @param: @param localDateTime
     * @param: @return
     * @param: @throws ParseException
     * @return: Date
     * @author: lcq
     * @date: 2019年3月21日 上午11:15:48
     * @version 1.0
     */
    public static final Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    public static Date parseToDate(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD);
        for (int i = 0; i < DATE_PATTERN.PARSE_PATTERNS.length; i++) {
            pos.setIndex(0);
            Date date = sdf.parse(s, pos);
            if (date != null && pos.getIndex() == (s).length()) {
                return date;
            }
            sdf.applyPattern(DATE_PATTERN.PARSE_PATTERNS[i]);
        }
        return null;
    }

    /**
     * 
     * @Title: manageDate   
     * @Description: 时间计算
     * @param: @param date 		日期
     * @param: @param formart 	转换格式
     * @param: @param type		Calendar.HOUR 等
     * @param: @param num		数（减    -1）
     * @param: @return      
     * @return: LocalDateTime      
     * @throws   
     * @author: lcq
     * @date:   2020年1月9日 下午3:06:42
     * @version 1.0
     */
    public static LocalDateTime manageDate(Date date ,String formart, int type, int num) {
		SimpleDateFormat sdf = new SimpleDateFormat(formart);
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(date);
		nowTime.add(type, num);
		return date2LocalDateTime(stringToDate(sdf.format(nowTime.getTime())));
	}
}
