package com.cp.string;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateChange {
  public static void main(String[] args) {
    System.out.println(new DateChange().reformatDate("20th Oct 2052"));
  }
  public String reformatDate(String date) {
    Map<String, Integer> map = new HashMap<>();
    map.put("Jan", Calendar.JANUARY);
    map.put("Feb", Calendar.FEBRUARY);
    map.put("Mar", Calendar.MARCH);
    map.put("Apr", Calendar.APRIL);
    map.put("May", Calendar.MAY);
    map.put("Jun", Calendar.JUNE);
    map.put("Jul", Calendar.JULY);
    map.put("Aug", Calendar.AUGUST);
    map.put("Sep", Calendar.SEPTEMBER);
    map.put("Oct", Calendar.OCTOBER);
    map.put("Nov", Calendar.NOVEMBER);
    map.put("Dec", Calendar.DECEMBER);
    String[] s = date.split(" ");
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    String day = s[0].replace("th", "").replace("nd", "").replace("st", "");
    Date date1 = new Date(Integer.parseInt(s[2]) - 1900, map.get(s[1]), Integer.parseInt(day));
    return sd.format(date1);
  }
}
