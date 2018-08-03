package com.example.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {
    /**
     * 获取对象属性，返回一个字符串数组
     *
     * @param o 对象
     * @return String[] 字符串数组
     */
    private String[] getFiledName(Object o) {
        try {
            Field[] fields = o.getClass().getDeclaredFields();

            Class tempClass = o.getClass().getSuperclass();
            // 暂只考虑一级父类，多级可用while  tempClass = tempClass.getSuperclass();
            Field[] dadFileds = new Field[0];

            if (tempClass != null) {
                dadFileds = tempClass.getDeclaredFields();
            }
            int dadLength = dadFileds.length;
            int sonLength = fields.length;
            dadFileds = Arrays.copyOf(dadFileds, dadFileds.length+fields.length);
            System.arraycopy(fields, 0, dadFileds, dadLength, sonLength);

            String[] fieldNames = new String[dadFileds.length];
            for (int i = 0; i < dadFileds.length; i++) {
                fieldNames[i] = dadFileds[i].getName();
            }
            return fieldNames;
        } catch (SecurityException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return null;
    }


    /**
     * 使用反射根据属性名称获取t属性的get方法
     *
     * @param fieldNames 属性名称
     * @param o 操作对象
     * @return List<Method> get方法
     */

    private List<Method> getGetField(String[] fieldNames, Object o) {

        List<Method> methods=new ArrayList<Method>();
        for (String fieldName : fieldNames) {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = null;
            try {
                method = o.getClass().getMethod(getter, new Class[] {});
            } catch (NoSuchMethodException e) {
                System.out.println("属性不存在");
                continue;
            }
            methods.add(method);
        }
        return methods;

    }
    /**
     * 将list集合转换为二维string数组
     *
     * @param list 要转换的集合
     * @return String[][] 返回的sting数组
     */

    public String[][] listToArrayWay(List list) {
        Object o=list.get(0);

        String[] filedNames = getFiledName(o);
        int filedNum=filedNames.length;
        int listSize=list.size();
        List<Method> methods=getGetField(filedNames, o);

        String[][] arrs=new String[listSize][filedNum];
        int i=0;
        for (Object object : list) {
            int j=0;
            for (Method method : methods) {
                Object value=null;
                try {
                    value = method.invoke(object, new Object[] {});
                } catch (Exception e) {
                    System.out.println("属性不存在"+e);
                }
                if (value != null){
                    arrs[i][j]= value + "";
                    j++;
                } else {
                    continue;
                }

            }
            i++;
        }

        return arrs;
    }

}
