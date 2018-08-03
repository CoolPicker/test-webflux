package com.example.demo.test;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @Author: nya
 * @Description:
 * @Date: Created in 16:26 2018/7/30
 * @Modify by:
 */
public class RomanToInt {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        String s = Arrays.toString(a);
        Integer[] m = {};
        Integer[] integers = Arrays.stream(a).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));
    }
}
class Solution {
    public int romanToInt(String s) {
        int I = 1 ;
        int V = 5 ;
        int X = 10 ;
        int L = 50 ;
        int C = 100 ;
        int D = 500 ;

        int M = 1000 ;

        return 0;

    }
}