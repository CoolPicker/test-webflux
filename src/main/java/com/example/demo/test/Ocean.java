package com.example.demo.test;

/**
 * @Author: nya
 * @Description: 实现Water接口的测试实现类
 * @Date: Created in 17:49 2018/7/30
 * @Modify by:
 */
public class Ocean implements Water {
    @Override
    public void size() {
        System.out.println("Ocean size init");
    }

    @Override
    public String square(int length, int with, int height) {
        System.out.println("length: "+length + " with: "+with+" height: "+height);
        return "Ocean square init";
    }
}
