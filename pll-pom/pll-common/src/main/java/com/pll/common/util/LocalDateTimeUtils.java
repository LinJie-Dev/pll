package com.pll.common.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * LocalDateTimeUtil工具类
 *
 * @author 张云和
 *
 * @date 2020/5/20 11:00 上午
 */
public class LocalDateTimeUtils {

    public static final String YYYY = "yyyy";

    public static final String YYYYMM = "yyyyMM";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String HHMMSS = "HHMMSS";
    public static final String HH_MM = "HH:mm";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String MMdd = "MMdd";

    /**
     * Date转换为LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        if (null == date) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param time
     * @return
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        if (null == time) {
            return null;
        }
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定日期的毫秒
     *
     * @param time
     * @return
     */
    public static Long getMilliByTime(LocalDateTime time) {
        if (null == time) {
            return 0L;
        }
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒
     *
     * @param time
     * @return
     */
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取指定时间的指定格式
     *
     * @param time
     * @param pattern
     * @return
     */
    public static String formatTime(LocalDateTime time, String pattern) {
        if (null == time) {
            return "";
        }
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 字符串转日期
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static LocalDateTime parseDateTime(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateStr, df);
    }

    /**
     * 获取常规的日期格式
     *
     * @param time
     * @return
     */
    public static String formatNormalData(LocalDateTime time) {
        if (null == time) {
            return null;
        }
        return time.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS));
    }

    /**
     * 获取当前时间的指定格式
     *
     * @param pattern
     * @return
     */
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
     *
     * @param time
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        if (null == time) {
            return null;
        }
        return time.plus(number, field);
    }

    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
     *
     * @param time
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        if (null == time) {
            return null;
        }
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差 field参数为ChronoUnit.*
     *
     * @param startTime
     * @param endTime
     * @param field
     *            单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 获取一天的开始时间，2017,7,22 00:00
     *
     * @param time
     * @return
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        if (null == time) {
            return null;
        }
        return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    /**
     * 获取一天的结束时间，2017,7,22 23:59:59
     *
     * @param time
     * @return
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        if (null == time) {
            return null;
        }
        return time.withHour(23).withMinute(59).withSecond(59);
    }

}
