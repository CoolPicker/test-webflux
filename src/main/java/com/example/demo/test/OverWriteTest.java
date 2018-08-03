package com.example.demo.test;

/**
 * @Author: nya
 * @Description:
 * @Date: Created in 16:52 2018/7/27
 * @Modify by:
 */
public class OverWriteTest {
    public static void main(String[] args) {
        Father.test();
        Son.test();
    }
}

class Father {
    static void test(){
        System.out.println(232323);
    }
}
class Son extends Father {
    static void test(){
        System.out.println(111111);
    }
}
