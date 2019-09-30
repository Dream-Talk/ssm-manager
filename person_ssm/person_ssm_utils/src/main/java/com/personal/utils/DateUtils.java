package com.personal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String  DateToString(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.format(date);
    }
    public static Date StringToDate(String str,String patt) throws ParseException {
       SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.parse(str);
    }
}
