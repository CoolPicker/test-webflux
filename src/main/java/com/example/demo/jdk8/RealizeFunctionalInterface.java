package com.example.demo.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: nya
 * @Description: 关于lambda的具体使用详解
 *              函数式接口详解
 * @Date: Created in 9:10 2018/8/2
 * @Modify by:
 */
public class RealizeFunctionalInterface {
    public static void main(String[] args) {
        /**
         * Lambda表达式，基础语法
         * expression = (variable) -> action
         *  variable: 这是一个变量,一个占位符。像x,y,z,可以是多个变量
         *  action: 实现的代码逻辑部分,它可以是一行代码也可以是一个代码片段
         * based 函数式接口,@FunctionalInterface,只有一个方法的接口，用作lambda表达式的类型
         */
        Runnable r = () -> {
            System.out.println("test the runnable");
            System.out.println("hahah");
        };
        r.run();

        boolean isAdult = doPredicate(20,x -> x >= 18);
        System.out.println(isAdult);
        boolean isChild = doPredicate(19,x -> x < 18 );
        System.out.println(isChild);

        /**
         * JDK8中,函数式接口位于java.util.function包下,大致分为以下几类:
         *  接口        参数    返回值     类型          实例
         *  Consumer    T       void    消费型接口   输出一个值
         *  Supplier    None    T       供给型接口   工厂方法
         *  Function    T       R       函数型接口   获得Artist对象的名字
         *  Predicate   T       boolean 断言型接口   这张唱片已经发行了吗
         */
        System.out.println("-----------------Consumer---------------------------");
        donation(500,money -> System.out.println("Here once accept TEMP " + money + " yuan.")); // 消费型接口
        System.out.println("-----------------Supplier---------------------------");
        List<Integer> supplyList = supply(10, () -> (int) (Math.random() * 100)); // 供给型接口
        supplyList.forEach(System.out::println);
        System.out.println("-----------------Function---------------------------");
        Integer convert = convert("25", x -> Integer.parseInt(x));
        System.out.println(convert);
        System.out.println("-----------------Predicate--------------------------");
        List<String> fruit = Arrays.asList("香蕉","火龙果","苹果","梨","芒果");
        List<String> newFruit = filter(fruit, (f) -> f.length() == 2);
        System.out.println(newFruit);
        System.out.println("-----------------接口默认方法------------------------");
        List<Integer> list = Arrays.asList(4, 5, 6, 2, 3, 45, 23, 44, 22);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }

    /**
     * 消费型接口示例
     * @param money 参数
     * @param consumer Consumer
     */
    private static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }
    /**
     * 供给型接口示例
     * @param num 参数
     * @param supplier Supplier
     * @return Integer集合
     */
    private static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> resultList = new ArrayList<>();
        for (int x = 0 ; x < num ; x++)
            resultList.add(supplier.get());
        return resultList;
    }
    /**
     * 函数型接口
     * @param str param
     * @param function 具体函数
     * @return 返回结果
     */
    private static Integer convert(String str, Function<String,Integer> function) {
        return function.apply(str);
    }
    /**
     * 断言型接口
     * @param fruit 参数
     * @param predicate 断言
     * @return 结果
     */
    private static List<String> filter(List<String> fruit,Predicate<String> predicate) {
        List<String> f = new ArrayList<>();
        for (String s : fruit) {
            if (predicate.test(s)){
                f.add(s);
            }
        }
        return f;
    }

    /**
     * 函数式接口,指向构造,逻辑自拟
     * @param <T>
     */
    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }
    private static boolean doPredicate(int age, Predicate<Integer> predicate) {
        return predicate.test(age);
    }
}
