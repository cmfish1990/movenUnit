/*
 * cf
 * FileName: DateUtils.java
 * Author:   BM
 * Date:     2019-04-03 13:44:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 13:44:37> <version> <desc> <source>
 *
 */

package wk.utils;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 * <功能详细描述>

 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtils {

    /**
     * 使用ThreadLocal来处理多线程情况下SimpleDateFormat线程不安全的问题
     */
    private static ThreadLocal<Map<String, SimpleDateFormat>> store = new ThreadLocal<Map<String, SimpleDateFormat>>() {
        @Override
        protected Map<String, SimpleDateFormat> initialValue() {
            return new HashMap<String, SimpleDateFormat>();
        }

        ;
    };


    private static String[] dftFmt = new String[]{
            "yyyy/MM/dd HH:mm:ss"
            , "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"
    };

    public static Date parseDate(String s) {
        for (String fmt : dftFmt) {
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            try {
                return sdf.parse(s);
            } catch (ParseException ignored) {
            }
        }
        return null;
    }


    /**
     * 定义常量*
     */
    public static final String DATE_JFP_STR = "yyyyMM";
    public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SMALL_STR = "yyyy-MM-dd";
    public static final String DATE_KEY_STR = "yyMMddHHmmss";

    public static final String YYYYMMDD0 = "yyyyMMdd";
    public static final String YYYYMMDD1 = "yyyy/MM/dd";

    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    /**
     * 带斜杠的日期格式化
     */
    public static final String DATE_FULL_STR_SLASH = "yyyy/MM/dd HH:mm:ss";

    public static String formatYYYYMMDD0(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD0);
        return sdf.format(date);
    }
    public static String formatYYYYMMDD1(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD1);
        if (null == date) {
            return null;
        }
        return sdf.format(date);
    }
    public static String formatYYYYMMDDHHmm(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_KEY_STR);
        return sdf.format(date);
    }
    public static String formatYYYYMMDDHHmmSlash(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FULL_STR_SLASH);
        return sdf.format(date);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date parse(String date, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(date);
    }

    public static Date addMonth(Date date, int monthamount) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        cal.add(Calendar.MONTH, monthamount);
        Date date2 = cal.getTime();
        return date2;
    }

    public static Date addDay(Date source, int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(source);
        calendar.add(calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 日期加减
     *
     * @param date 需要加减的日期
     * @param type 类型（年--Calendar.YEAR、月--Calendar.MONTH、日--Calendar.DATE）
     * @param num  加减数量（负数为减）
     * @return
     */
    public static Date addTime(Date date, int type, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(type, num);
        return cal.getTime();
    }

    public static Integer[] getMonthsAndDaysBetween(Date early, Date late) {

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(early);
        c2.setTime(late);
        // 日
        int day1 = c1.get(Calendar.DATE);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);

        int day2 = c2.get(Calendar.DATE);

        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);


        return days(year1, month1, day1, year2, month2, day2);

    }

    /**
     * @param year1
     * @param month1
     * @param day1
     * @param year2
     * @param month2
     * @param day2
     * @return list[0] 天数，list[0] 是否需要月份减1
     */
    private static Integer[] days(int year1, int month1, int day1, int year2, int month2, int day2) {

        int daysOfMonth1 = getDaysOfMonth(year1, month1);

        int daysOfMonth2 = getDaysOfMonth(year2, month2);

        // 修正日期
        int addDays = daysOfMonth1 - daysOfMonth2;

        int days = 0;
        int subMonth = 0;
        if (month2 != 1 && day2 >= day1 - 1) {
            days = day2 - day1 + 1;
            subMonth = 0;

        } else if (month2 == 1) { // 二月
            if (month1 == 1) {
                days = day2 - day1 + 1;

            } else {

                days = daysOfMonth1 - day1 + 1 + day2;
                subMonth = 1;
            }

        } else {

            days = daysOfMonth1 - day1 + 1 + day2;
            subMonth = 1;

        }

        // kuan yue
        if (month2 != month1) {
            // days =days+addDays;

        }

        // 15 tian full month
        // if(day2>15){

        if (days >= daysOfMonth2 && day2 == daysOfMonth2) {
            subMonth = subMonth - 1;
            days = days - daysOfMonth2;

        }
        // if(day2==daysOfMonth2 && month2!=month1){
        // days =days + addDays;

        // }

        // }else{

        if (days >= daysOfMonth1) {
            subMonth = subMonth - 1;
            days = days - daysOfMonth1;
        }
        // }

        int subYear = 0;
        int months = 0;
        if (month2 - subMonth >= month1) {

            months = month2 - month1 - subMonth;
            subYear = 0;
        } else {

            months = 12 - month1 + month2 - subMonth;

            subYear = 1;
        }

        int years = year2 - year1 - subYear;

        /*
         * List list = new ArrayList(); list.add(days); list.add(subMonth);
         */

        return new Integer[]{years, months, days};

    }

    public static int getDaysOfMonth(int year, int month) {
        int days = 0;
        switch (month + 1) {
            case 2:
                int daysOfFeb = 28;
                if (year % 4 == 0) {
                    daysOfFeb = 29;
                }
                days = daysOfFeb;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = 30;
        }
        return days;
    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getCurrentTime(String type) {
        SimpleDateFormat df = new SimpleDateFormat(type);
        return df.format(new Date());
    }

    /**
     * getCurDate 取当前日期
     *
     * @return java.util.Date型日期
     */
    public static Date getCurDate() {
        return (new Date());
    }

    /**
     * getCurTimestamp 取当前时间戳
     *
     * @return java.sql.Timestamp
     */
    public static Timestamp getCurTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /*
    * 日期转换成字符串
    * @param date
    * @return
    */
    public static String dateToString(Date paramDate, String paramString) {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
                paramString);
        localSimpleDateFormat.setLenient(false);
        return localSimpleDateFormat.format(paramDate);
    }

    /**
     * 字符串转换日期
     *
     * @param dataStr,formatStr
     * @return
     */
    public static Date stringToDate(String dataStr, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        if (!dataStr.equals("") && dataStr != null) {
            try {
                return format.parse(dataStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getDaysOfMonthByDate(Date date) {

        Calendar c1 = Calendar.getInstance();

        c1.setTime(date);

        // 日
        int day1 = c1.get(Calendar.DATE);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);

        return getDaysOfMonth(year1, month1);

    }

    // 相差天数
    public static final int getDaysBetween(Date early, Date late) {

        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        // 设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);

        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);

        // 得到两个日期相差的天数

        long time1 = calst.getTimeInMillis();
        long time2 = caled.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        int days = Integer.parseInt(String.valueOf(between_days));
        return days;
    }

    // 计算剩余期限
    // 1 剩余月分,2 换房当月剩余责任天数,3 换房当月总天数
    public static Integer[] calLeftPeriod(Date beginDate, Date endDate, Date changeDate) {
        // 原期限
        Integer[] period_all = getMonthsAndDaysBetween(beginDate, endDate);

        Date lastLiveDate = addTime(changeDate, Calendar.DATE, -1);

        // 已住
        Integer[] period_living = getMonthsAndDaysBetween(beginDate, lastLiveDate);

        int liveday = period_living[2];
        int monthDiff = 0;

        int daysOfMonth = getDaysOfMonthByDate(changeDate);

        int dayDiff = 0;
        if (liveday == 0) {
            monthDiff = period_all[1] - period_living[1];
        } else {
            monthDiff = period_all[1] - period_living[1] - 1;
            Integer[] period_noLive = getMonthsAndDaysBetween(changeDate, endDate);
            dayDiff = period_noLive[2];
//                dayDiff = daysOfMonth - liveday;
        }
        return new Integer[]{monthDiff, dayDiff, daysOfMonth};
    }

    /**
     * This method generates a string representation of a date/time in the format you specify on input
     *
     * @param aMask   the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @throws ParseException when String doesn't match the expected format
     * @see SimpleDateFormat
     */
    public static Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(aMask);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            // log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    public static String getRentRange(Date beginDate, Date endDate) {// 日期间隔
        Integer[] dateRangeArray = getMonthsAndDaysBetween(beginDate, endDate);
        String str = "";
        if (dateRangeArray[0] >= 1) {
            str += dateRangeArray[0] + "年";
        }
        if (dateRangeArray[1] >= 1) {
            str += dateRangeArray[1] + "月";
        }
        if (dateRangeArray[2] >= 1) {
            str += dateRangeArray[2] + "天";
        }
        return str;
    }

    public static String getRentRange(Date beginDate, Date endDate, Boolean hasYear) {// 日期间隔
        Integer[] dateRangeArray = getMonthsAndDaysBetween(beginDate, endDate);
        String str = "";
        if(!hasYear){
            int mouth = 0;
            if (dateRangeArray[0] >= 1) {
                mouth = dateRangeArray[0] * 12;
            }
            if (dateRangeArray[1] >= 1 || mouth >= 1) {
                str += mouth + dateRangeArray[1] + "个月";
            }
            if (dateRangeArray[2] >= 1) {
                str += dateRangeArray[2] + "天";
            }
        } else {
            if (dateRangeArray[0] >= 1) {
                str += dateRangeArray[0] + "年";
            }
            if (dateRangeArray[1] >= 1) {
                str += dateRangeArray[1] + "月";
            }
            if (dateRangeArray[2] >= 1) {
                str += dateRangeArray[2] + "天";
            }
        }
        return str;
    }

    public static int compareToCurTime(Date date) throws Exception {
        int ret = 0;
        try {
            Date curDate = new Date();
            ret = curDate.compareTo(date);
        } catch (Exception e) {
            throw new Exception("error compare date", e);
        }
        return ret;
    }

    /**
     * 计算两个时间相差（天、小时、分钟、秒）
     *
     * @param startTime
     * @param endTime
     * @param str
     * @return
     * @throws Exception
     */
    public static Long dateDiff(Date startTime, Date endTime, String str) throws Exception {
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        // 获得两个时间的毫秒时间差异
        try {
            diff = endTime.getTime() - startTime.getTime();
            day = diff / nd;// 计算差多少天
            hour = diff % nd / nh + day * 24;// 计算差多少小时
            min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
            sec = diff % nd % nh % nm / ns;// 计算差多少秒
            if (str.equalsIgnoreCase("h")) {
                return hour;
            } else {
                return min;
            }
        } catch (Exception e) {
            throw new Exception("dateDiff error", e);
        }
    }

    public static Date getStartTime(Date date) {
        Calendar start = Calendar.getInstance();
        start.setTime(date);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        return start.getTime();
    }

    public static Date getEndTime(Date date) {
        Calendar end = Calendar.getInstance();
        end.setTime(date);
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.MILLISECOND, 999);
        return end.getTime();
    }

    /**
     * 获取传入日期所属月份的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取传入日期所属月份的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                calendar.set(Calendar.DAY_OF_MONTH, 31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                calendar.set(Calendar.DAY_OF_MONTH, 30);
                break;
            case 2:
                int year = calendar.get(Calendar.YEAR);
                boolean isLeap = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
                calendar.set(Calendar.DAY_OF_MONTH, isLeap ? 29 : 28);
                break;
        }
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取当月的 天数
     */
    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 根据年 月 获取对应的月份 天数
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取上个月的时间
     *
     * @param date
     * @return
     */
    public static Date getLastDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 获得两个日期之前相差的月份
     *
     * @param start
     * @param end
     * @return
     */
    public static int getMonth(Date start, Date end) {
        if (start.after(end)) {
            Date t = start;
            start = end;
            end = t;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar temp = Calendar.getInstance();
        temp.setTime(end);
        temp.add(Calendar.DATE, 1);

        int year = endCalendar.get(Calendar.YEAR)
                - startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH)
                - startCalendar.get(Calendar.MONTH);

        if ((startCalendar.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month + 1;
        } else if ((startCalendar.get(Calendar.DATE) != 1)
                && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month;
        } else if ((startCalendar.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) != 1)) {
            return year * 12 + month;
        } else {
            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }
    }

    /**
     * 判断MySQL数据库输入的日期是否为空
     * <br>
     * 如果为null或者0000-00-00 00:00:00则视为空，否则视为非空
     *
     * @param date 输入的日期
     * @return 如果为空则返回true，否则返回false
     */
    public static boolean isEmpty(Date date) {
        if (date == null) {
            return true;
        } else {
            String dateStr = DateUtils.format(date, "yyyyMMddHHmmss");
            if (dateStr.equals("00000000000000")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取指定日期对应一天的开始时间
     *
     * @param date 日期
     * @return 开始时间
     */
    public static Calendar getBeginOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * 获取指定日期对应一天的结束时间
     *
     * @param date 日期
     * @return 结束时间
     */
    public static Calendar getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }

    /**
     * 判断两个时间是否相等
     *
     * @param source
     * @param target
     * @return
     */
    public static boolean compareDate(Date source, Date target) {
        Format f = new SimpleDateFormat(DATE_SMALL_STR);
        String date1 = f.format(source);
        String date2 = f.format(target);
        return date1.equals(date2);
    }

}
