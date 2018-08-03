package com.example.demo.test;

import com.example.demo.util.ListToArray;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

public class CalendarTest {

    public static void main(String[] args) throws ParseException {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY,11);
//        calendar.set(Calendar.SECOND,0);
//        calendar.set(Calendar.MINUTE,20);
//        calendar.add(Calendar.MINUTE,50);
//        System.out.println(calendar.getTime());
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        List<Integer> list = new ArrayList<>();
//        Map map = new HashMap(list.size());
//        for (Integer i :
//                list) {
//            map.put("tom",i);
//        }
//        System.out.println(map.size());
//        System.out.println(map.get("tom"));
//
//        String l = System.currentTimeMillis() + "99999";
//        Long l1 = Long.parseLong(l);
//        System.out.println(l1);
//        System.out.println(Long.MAX_VALUE);
//        String ll = l1.toString();
//        System.out.println(ll.substring(ll.length()-5));
//
//        List<Integer> list9 = new ArrayList<>();
//        for (int i = 0 ; i < 100 ; i ++){
//            list9.add(i);
//            if (list9.size() == 10 ) {
//                break;
//            }
//        }
//        System.out.println(list9);
//
//        System.out.println(Integer.MAX_VALUE);
//        Method[] methods = ListToArray.class.getMethods();
//        for (Method method:
//             methods) {
//            System.out.println(method.getName());
//        }
//        List<Integer> list1 = new ArrayList<>(2);
//        list1.add(2);
//        list1.add(3);
//        List<Integer> list2 = new ArrayList<>(2);
//        list2.add(5);
//        list2.add(6);
//        test(list1,list2);
//        System.out.println("list1:"+list1+" list2:"+list2);
//        Calendar calendarTest = Calendar.getInstance();
//        calendarTest.set(Calendar.HOUR_OF_DAY,22);
//        calendarTest.set(Calendar.MINUTE,0);
//        calendarTest.set(Calendar.SECOND,0);
//        calendarTest.add(Calendar.MINUTE,120);
//        System.out.println(calendarTest.get(Calendar.HOUR_OF_DAY));
//        System.out.println("---------------------------------------------");
//        Date monday = DateUtils.parseDate("20180723", "yyyyMMdd");
//        Calendar mondayCalendar = Calendar.getInstance();
//        mondayCalendar.setTime(monday);
//        Date tuesday = DateUtils.parseDate("20180724", "yyyyMMdd");
//        Calendar tuesdayCalendar = Calendar.getInstance();
//        tuesdayCalendar.setTime(tuesday);
//        Date wednesday = DateUtils.parseDate("20180725", "yyyyMMdd");
//        Calendar wednesdayCalendar = Calendar.getInstance();
//        wednesdayCalendar.setTime(wednesday);
//        Date thursday = DateUtils.parseDate("20180726", "yyyyMMdd");
//        Calendar thursdayCalendar = Calendar.getInstance();
//        thursdayCalendar.setTime(thursday);
//        Date friday = DateUtils.parseDate("20180727", "yyyyMMdd");
//        Calendar fridayCalendar = Calendar.getInstance();
//        fridayCalendar.setTime(friday);
//        Date saturday = DateUtils.parseDate("20180728", "yyyyMMdd");
//        Calendar saturdayCalendar = Calendar.getInstance();
//        saturdayCalendar.setTime(saturday);
//        Date sunday = DateUtils.parseDate("20180729", "yyyyMMdd");
//        Calendar sundayCalendar = Calendar.getInstance();
//        sundayCalendar.setTime(sunday);
//
//        System.out.println(mondayCalendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println(tuesdayCalendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println(wednesdayCalendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println(thursdayCalendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println(fridayCalendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println(saturdayCalendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println(sundayCalendar.get(Calendar.DAY_OF_WEEK));
        CalendarTest.test();
    }

    public static void test() throws ParseException {
//        List temp = list1;
//        list1 = list2;
//        list2 = temp;
//        System.out.println("list1--:"+list1+" list2--:"+list2);
        String a = "19990909";
        Date yyyyMMdd = DateUtils.parseDate(a, "yyyyMMdd");
        System.out.println(yyyyMMdd);
    }

}
