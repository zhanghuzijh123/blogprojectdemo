package com.jiahui.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTimeUtil {

    private static final String ALL_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String YEAR_PATTERN = "yyyy";
    private static final String MONTH_PATTERN = "yyyy-MM";
    private static final String DAY_PATTERN = "yyyy-MM-dd";
    private static final String HOUR_PATTERN = "yyyy-MM-dd HH";

    /**
     * 根据格式 返回完整的时间
     *
     * @param time   时间
     * @param type   类型 1-开始 2-结束(补齐后面)
     * @param format 格式 1-年(yyyy) 2-月(yyyy-MM) 3-天(yyyy-MM-dd) 4-小时(yyyy-MM-dd HH:mm:ss)
     * @return 完整的时间
     */
    public static Date getTimeByFormat(String time, Integer type, Integer format) throws ParseException {
        SimpleDateFormat yearFormat = new SimpleDateFormat(YEAR_PATTERN);
        SimpleDateFormat monthFormat = new SimpleDateFormat(MONTH_PATTERN);
        SimpleDateFormat dayFormat = new SimpleDateFormat(DAY_PATTERN);
        SimpleDateFormat hourFormat = new SimpleDateFormat(HOUR_PATTERN);
        Date res;
        Calendar cal = Calendar.getInstance();
        if (1 == format) {
            cal.setTime(yearFormat.parse(time));
            if (2 == type) {
                cal.set(Calendar.MONTH, 0);
                cal.add(Calendar.YEAR, 1);
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
        } else if (2 == format) {
            cal.setTime(monthFormat.parse(time));
            if (2 == type) {
                cal.set(Calendar.DAY_OF_MONTH, 1);
                cal.add(Calendar.MONTH, 1);
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
        } else if (3 == format) {
            cal.setTime(dayFormat.parse(time));
        } else if (4 == format) {
            cal.setTime(hourFormat.parse(time));
        }
        if (2 == type) {
            if (4 == format) {
                cal.add(Calendar.HOUR_OF_DAY, 1);
            } else {
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            cal.add(Calendar.MILLISECOND, -1);
        }
        res = (cal.getTime().getTime() > System.currentTimeMillis()) ? new Date() : cal.getTime();
        return res;
    }

    /**
     * 获取两个时间相差的月份、天、周、时
     *
     * @param start
     * @param end
     * @param dateType 1-每时 2-每周 3-每天 4-每月
     * @return
     * @throws Exception
     */
    public static List<String> getDateList(Date start, Date end, Integer dateType) throws Exception {
        SimpleDateFormat sdf;
        Date sDate;
        Date eDate;
        Calendar dd = Calendar.getInstance();
        List<String> list = new ArrayList<>();
        switch (dateType) {
            case 1:
                sdf = new SimpleDateFormat("HH:00");
                break;
            case 2:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case 3:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case 4:
                sdf = new SimpleDateFormat("yyyy-MM");
                break;
            default:
                throw new Exception("没有设置日期类型!");
        }
        sDate = sdf.parse(sdf.format(start));
        eDate = sdf.parse(sdf.format(end));
        dd.setTime(sDate);
        while (!dd.getTime().after(eDate)) {
            list.add(sdf.format(dd.getTime()));
            if (dateType == 1) {
                dd.add(Calendar.HOUR_OF_DAY, 1);
            } else if (dateType == 2) {
                dd.add(Calendar.DAY_OF_MONTH, 7);
            } else if (dateType == 3) {
                dd.add(Calendar.DAY_OF_MONTH, 1);
            } else if (dateType == 4) {
                dd.add(Calendar.MONTH, 1);
            } else {
                return null;
            }
        }
        return list;
    }

    public static List<String> getNewDateList(String dateTime, Integer dateType) throws Exception {
        SimpleDateFormat sdf;
        Date sDate;
        Date eDate;
        Calendar dd = Calendar.getInstance();
        List<String> list = new ArrayList<>();
        switch (dateType) {
            case 1:
                sdf = new SimpleDateFormat("HH:00");
                sDate = DateTimeUtil.getTimeByFormat(dateTime, 1, 3);
                eDate = DateTimeUtil.getTimeByFormat(dateTime, 2, 3);
                break;
            case 2:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                sDate = DateTimeUtil.getTimeByFormat(dateTime, 1, 2);
                eDate = DateTimeUtil.getTimeByFormat(dateTime, 2, 2);
                break;
            case 3:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                sDate = DateTimeUtil.getTimeByFormat(dateTime, 1, 2);
                eDate = DateTimeUtil.getTimeByFormat(dateTime, 2, 2);
                break;
            case 4:
                sdf = new SimpleDateFormat("yyyy-MM");
                sDate = DateTimeUtil.getTimeByFormat(dateTime, 1, 1);
                eDate = DateTimeUtil.getTimeByFormat(dateTime, 2, 1);
                break;
            default:
                throw new Exception("没有设置日期类型!");
        }
        sDate = sdf.parse(sdf.format(sDate));
        eDate = sdf.parse(sdf.format(eDate));
        dd.setTime(sDate);
        while (!dd.getTime().after(eDate)) {
            list.add(sdf.format(dd.getTime()));
            if (dateType == 1) {
                dd.add(Calendar.HOUR_OF_DAY, 1);
            } else if (dateType == 2) {
                dd.add(Calendar.DAY_OF_MONTH, 7);
            } else if (dateType == 3) {
                dd.add(Calendar.DAY_OF_MONTH, 1);
            } else if (dateType == 4) {
                dd.add(Calendar.MONTH, 1);
            } else {
                return null;
            }
        }
        return list;
    }

    /**
     *
     * @param nowTime   当前时间
     * @param startTime	开始时间
     * @param endTime   结束时间
     * @return
     * @author sunran   判断当前时间在时间区间内
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
