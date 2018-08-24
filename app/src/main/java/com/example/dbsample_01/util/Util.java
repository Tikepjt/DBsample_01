package com.example.dbsample_01.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String getToday()
    {
        String szToday;

        long now = System.currentTimeMillis();

        Date date = new Date(now);

        SimpleDateFormat CurYearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat CurMonthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat CurDayFormat = new SimpleDateFormat("dd");

        String strCurYear = CurYearFormat.format(date);
        String strCurMonth = CurMonthFormat.format(date);
        String strCurDay = CurDayFormat.format(date);

        szToday = strCurYear + strCurMonth + strCurDay;

        return szToday;
    }

    public static String getNowTime()
    {
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat CurHourFormat = new SimpleDateFormat("HH");
        SimpleDateFormat CurMinuteFormat = new SimpleDateFormat("mm");
        SimpleDateFormat CurSecFormat = new SimpleDateFormat("ss");

        String strCurHour = CurHourFormat.format(date);
        String strCurMinute = CurMinuteFormat.format(date);
        String strCurSecond = CurSecFormat.format(date);

        String szTime =  strCurHour + strCurMinute + strCurSecond;

        return szTime;
    }
}
