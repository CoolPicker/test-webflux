package com.example.demo.jvm;

/**
 * 查看并分析gc日志
 */
public class GCDetailAnalyze {
    private static final int _1MB = 1024 * 1024 ;

    public static void main(String[] args) {

        //System.out.println("gc--start");

        /**
         * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
         */
//        byte[] allocation1,allocation2,allocation3,allocation4;
//        allocation1 = new byte[_1MB / 4 ] ;
//        allocation2 = new byte[_1MB / 4 ] ;
//        allocation3 = new byte[4 * _1MB] ;
//        allocation4 = new byte[4 * _1MB] ;
//        allocation4 = null;
//        allocation4 = new byte[4 * _1MB];

        // 空间分配担保
        /**
         * VM参数：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
         */
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6,allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
}
