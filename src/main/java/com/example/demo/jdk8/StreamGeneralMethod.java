package com.example.demo.jdk8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: nya
 * @Description: Stream 常用方法集锦
 *  Summary:
 *      1. 不是数据结构
 *      2. 没有内部存储,只是用操作管道从source(数据结构/数组/generator function/IO channel)抓取数据
 *      3. 不修改自身所封装的底层数据结构的数据.eg-filter操作产生一个不包括被过滤元素的新Stream,而不是从source中删除
 *      4. 所有Stream操作必须以lambda表达式为参数
 *      5. 不支持索引访问
 *      6. 可以请求第一个元素,但无法请求第二个/第三个/最后一个
 *      7. 很容易生成数组/List
 *      8. 惰性化
 *      9. 很多Stream操作是向后延迟的,知道确定最后需要多少数据才会开始
 *      10. Intermediate操作永远是惰性化的
 *      11. 并行能力
 *      12. 当一个Stream是并行化的,就不需要再写多线程代码,所有对它的操作会自动并行进行
 *      13. 可以是无限的. 集合有固定大小,Stream则不必.limit(n)和findFirst()这类的short-circuiting操作可以对无限的Stream进行运算并很快完成.
 * @Date: Created in 11:12 2018/8/3
 * @Modify by:
 */
public class StreamGeneralMethod {
    public static void main(String[] args) throws IOException {
        /*
            how to use map
         */
        List<String> strings = Arrays.asList("tom", "Jerry", "motor");
        // 所有字符串转大写
        List<String> collect = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 获取所有整型的平方数
        List<Integer> collect1 = list.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(collect1);
        // 一对多 flatMap
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        List<Integer> collect2 = listStream.flatMap(childList -> childList.stream()).map(i -> i * 2).collect(Collectors.toList());
        System.out.println(collect2);
        // filter foreach peek
        Integer[] sixNums = {1,2,3,4,5,6};
        Integer[] integers = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        Stream.of(integers).forEach(System.out::println);
        int[] aaa = {3,6,9,11,12,34};
        IntStream stream = Arrays.stream(aaa);
        Stream<Integer> boxed = stream.boxed();
        Integer[] integers1 = boxed.toArray(Integer[]::new);
        Stream.of(integers1).forEach(System.out::println);
        List<String> collect3 = Stream.of("one", "two", "three", "four")
                .peek(s -> System.out.println("init:"+s))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("upper:"+e))
                .map(String::toLowerCase)
                .filter(s -> s.length() == 4)
                .collect(Collectors.toList());
        System.out.println(collect3);
        // 使用 Optional 判断空指针
        Integer aa = Optional.ofNullable("aa").map(String::length).orElse(-1); // 判断是否为null,为null返回-1,不为null返回字符串长度
        System.out.println(aa);
        // reduce 相关使用
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println("字符串连接:"+concat);
        Double minValue = Stream.of(-0.5, 1.0, -3.3, 2.5, -6.7).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("最小值:"+minValue);
        Integer sumValue = Stream.of(23, -12, 33, 26, -45).reduce(0, Integer::sum);
        System.out.println("整型求和:"+sumValue);
        String filterConcat = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
        System.out.println("过滤后连接:"+filterConcat);
        // limit/skip 返回前n个元素,或扔掉前n个元素
        // sorted 配合 Comparator , naturalOrder()正序 | reverseOrder()逆序 | 比较某一属性 comparing | 后续属性 thenComparing
        List<Integer> collect4 = Arrays.asList(2, 4, 5, 2, 6, 4, 1, 32, 43, 54, 23, 33).stream().sorted(Comparator.reverseOrder()).limit(5).skip(2).collect(Collectors.toList());
        System.out.println(collect4);
        // min / max / distinct
        BufferedReader br = new BufferedReader(new FileReader("G:\\idea.txt"));
        BufferedReader then = new BufferedReader(new FileReader("G:\\idea.txt"));
        int longest = br.lines().mapToInt(String::length).max().getAsInt();
        List<String> collect5 = then.lines()
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(word -> word.length() > 0)
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        br.close();
        then.close();
        System.out.println("idea.txt the longest line size : " + longest);
        System.out.println(collect5);
        // Match | 匹配 allMatch anyMatch noneMatch
        List<Person> people = Arrays.asList(
                new Person(1,"小明",12),
                new Person(2,"老刘",33),
                new Person(4,"小黄",2),
                new Person(9,"老王",45),
                new Person(7,"小王",25),
                new Person(11,"明明",25),
                new Person(8,"大孙",38),
                new Person(5,"老王头",79),
                new Person(6,"大黄",5),
                new Person(3,"老孙头",69));
        boolean agedAll = people.stream().allMatch(person -> person.getAge() > 60);
        System.out.println("都是老年人  " + agedAll);
        boolean noneAged = people.stream().noneMatch(person -> person.getAge() > 60);
        System.out.println("都不是老年人 " + noneAged);
        boolean anyAged = people.stream().anyMatch(person -> person.getAge() > 60);
        System.out.println("部分是老年人 " + anyAged);
        // Stream.generate 自动生成流
        Random seek = new Random();
        Supplier<Integer> random = seek::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        IntStream.generate(() -> (int)System.nanoTime() % 100).limit(10).forEach(System.out::println);
        // 自实现 Supplier
        List<Person> collect6 = Stream.generate(new PersonSupplier()).limit(10).collect(Collectors.toList());
        System.out.println(collect6);
        // Stream.iterate 类似 reduce,接受一个种子值和一个UnaryOperator
        List<Integer> collect7 = Stream.iterate(0, i -> i + 3).limit(10).collect(Collectors.toList());
        System.out.println(collect7);

        // 用 Collectors 进行 reduction 操作
        // groupingBy / partitioningBy
        Map<Integer, List<Person>> collect8 = Stream.generate(new PersonSupplier())
                .limit(100)
                .collect(Collectors.groupingBy(Person::getAge));
        collect8.keySet().stream()
                .forEach(item -> {
                    int size = collect8.get(item).size();
                    System.out.println("Age " + item + " with the size = " + size);
                });
        Map<Boolean, List<Person>> collect9 = Stream.generate(new PersonSupplier())
                .limit(100)
                .collect(Collectors.partitioningBy(person -> person.getAge() < 18));
        System.out.println("children size : " + collect9.get(true).size());
        System.out.println("adult size : " + collect9.get(false).size());
    }
    private static class PersonSupplier implements Supplier<Person> {
        private int index = 0;
        private Random random = new Random();
        @Override
        public Person get() {
            int id = index++;
            return new Person(id,"name"+id,random.nextInt(100));
        }
    }
}

