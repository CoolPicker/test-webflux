package com.example.demo.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: nya
 * @Description:
 * @Date: Created in 17:51 2018/7/30
 * @Modify by: none
 */
public class WaterTest {


    public static void main(String[] args) {
        // 获得要增强实现类的对象
        Water water = new Ocean();

        /*
         * Proxy为代理类。
         * newProxyInstance为Proxy的静态方法，此方法用于实现动态代理
         * 返回值为增强类要实现的接口对象
         * 此方法需要接受三个参数:类加载器、被增强类所要实现的全部接口、处理类
         *
         */
        //类加载器
        ClassLoader classLoader = water.getClass().getClassLoader();
        //被增强类所要实现的全部接口
        Class<?>[] interfaces = water.getClass().getInterfaces();
        //处理类一般是通过创建匿名内部类来实现的。
        Water waterProxy = (Water) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            /*
             * proxy:产生的代理对象的引用
             * method:当前正在调用的目标类的方法
             * params：只在执行的方法中的参数。
             */
            //需要注意的是我们无论调用waiterProxy中的任何方法都会执行invoke。所以我们可以在invoke中做一个判断，
            //从而只执行我们想要的方法。
            @Override
            public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
                //根据方法名来执行我们需求中的方法。
                if("square".equals(method.getName())){
                    System.out.println("呼呼");
                    //这里我们使用了method的invoke来执行waiterProxy中的方法。
                    int result = (int)params[0] * (int)params[1] * (int)params[2];
                    System.out.println("哗哗");
                    return result+"";
                }else{
                    System.out.println("come--------");
                    //只执行了原来的方法，没有进行增强。
                    Object object = method.invoke(water, params);
                    System.out.println("------go");
                    return object;
                }
            }
        });
        waterProxy.size();
        String square = waterProxy.square(3, 4, 5);
        System.out.println(square);
    }

}
