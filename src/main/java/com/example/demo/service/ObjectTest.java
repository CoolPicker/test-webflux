package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ObjectTest {

    public static void main(String[] args) {
        String[] str1 = {"Hello","world","java"};
        String[] str2 = {"Veriable","syntax","interator"};
        int str1Length = str1.length;
        int str2length = str2.length;

        str1 = Arrays.copyOf(str1, str1Length+str2length);//数组扩容
        System.arraycopy(str2, 0, str1, str1Length, str2length);
        System.out.println(Arrays.toString(str1));

        SimpleDateFormat format =  new SimpleDateFormat("HH:mm");
        Long time= System.currentTimeMillis();
        String d = format.format(time);
        System.out.println(d);
        Map map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map);
    }

}
