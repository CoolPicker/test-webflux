package com.example.demo.jvm;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: nya
 * @Description:
 * @Date: Created in 10:28 2018/7/23
 * @Modify by:
 */
public class VirtualJavaTest {
    public static void main(String[] args) throws ParseException {

//        boolean a = true;
//        if (a) System.out.println("hello,java");
//        if (true == a) System.out.println("Hello,world");
//        Integer ab = 7/4;
//        System.out.println(ab);
//
//        Date date = DateUtils.parseDate("20180720", "yyyyMMdd");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.HOUR_OF_DAY,20);
//        System.out.println(calendar.getTimeInMillis());
//        String aa = "+-2";
//        int i = VirtualJavaTest.myAtoi(aa);
//        System.out.println(i);
//        String bb = "20000000000000000000";
//        System.out.println(bb.length());
//
//        System.out.println((Long.MAX_VALUE+"").length());
        double b = 0.1;
        BigDecimal bb = new BigDecimal(b);

        BigDecimal add = new BigDecimal(0) ;
        for (int i = 0 ; i < 1000 ; i++){
            add = add.add(bb);
            System.out.println(add);
            System.out.println(add.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
        }

    }

    public static int myAtoi(String str) {
        int result = 0 ;
        if (str != null && !"".equals(str)){
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            Pattern pat = Pattern.compile("^[0-9]*$");
            String first = str.substring(0, 1);
            if (pattern.matcher(first).matches()){
                StringBuffer sb = new StringBuffer();
                if (str.length()>1){
                    sb.append(first);
                    for (int i = 1; i < str.length();i++){
                        if (pat.matcher(str.charAt(i)+"").matches()){
                            if((str.charAt(i)+"").equals("+") || (str.charAt(i)+"").equals("-")){
                                break;
                            }else{
                                sb.append(str.charAt(i));
                                BigInteger l = new BigInteger(sb.toString());

                                if (l.compareTo(new BigInteger(Integer.MAX_VALUE+""))>0){
                                    result = Integer.MAX_VALUE;
                                } else if (l.compareTo(new BigInteger(Integer.MIN_VALUE+"")) < 0){
                                    result = Integer.MIN_VALUE;
                                } else {
                                    result = Integer.parseInt(sb.toString());
                                }
                            }

                        }else {
                            break;
                        }
                    }

                }
            } else {
                result = 0;
            }
        }


        return result;
    }

}
