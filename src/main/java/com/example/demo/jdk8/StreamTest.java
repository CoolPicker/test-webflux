package com.example.demo.jdk8;

import org.apache.logging.log4j.util.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/**
 * @Author: nya
 * @Description: 测试Stream流
 *  Stream流仅仅代表数据流,并没有数据结构.其来源可以是Collection/Array/IO
 *  具有过滤/映射以及减少遍历数等方法,这些方法有分为中间方法和终端方法.中间方法返回的是stream,其它则为重点方法.
 *
 * @Date: Created in 13:25 2018/8/2
 * @Modify by:
 */
public class StreamTest {
    public static void main(String[] args) {
        // filter 按照指定条件过滤流中
        // map 转换参数类型
        // count 计数
        // collect 生成新的集合
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
        List<Person> aged = people.stream()
                .filter(p -> p.getAge() >= 60)
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("老年人组: " + aged + " 共 " + aged.stream().count() + " 人");
        List<Young> juveniles = people.stream()
                .filter(person -> person.getAge() < 18)
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getId))
                .map(person -> (Young) new Young().setTag("today").setId(person.getId()).setAge(person.getAge()).setName(person.getName()))
                //.map(person -> new Young().setTag("good"))
                .collect(Collectors.toList());
        System.out.println("未成年人组: " + juveniles + " 共 " + juveniles.stream().count() + " 人");
        List<Person> prime = people.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 60)
                .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getId).reversed())
                .collect(Collectors.toList());
        System.out.println("壮年组: " + prime + " 共 " + prime.stream().count() + " 人");
        juveniles.forEach(young -> System.out.println(
            "Young{id=" + young.getId() + " , "
            +"name=" + young.getName() + " , "
            +"age=" + young.getAge() + " , "
            +"tag=" + young.getTag() + "}"));
        int[] a = {1,3,4,5,6};
        Integer[] integers = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Arrays.stream(a).filter(i -> i > 4).sorted().forEach(System.out::println);
        System.out.println(integers);
        List<Integer> integerList = new ArrayList<>(10000000);
        for (int i = 1 ; i <= 10000000 ; i++) {
            integerList.add(i);
        }
        long be = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (Integer i :
                integerList) {
            if (i > 5000) {
                list.add(i);
            }
        }
        System.out.println(list.size());
        long en = System.currentTimeMillis();
        System.out.println("user ms " + (en - be));

        long st = System.currentTimeMillis();
        List<Integer> collect = integerList.stream().filter(i -> i > 5000).parallel().collect(Collectors.toList());
        System.out.println(collect.size());
        long th = System.currentTimeMillis();
        System.out.println("now use ms "+ (th - st));
    }
}
class Person {
    private Integer id ;
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Young extends Person {
    private String tag;

    public String getTag() {
        return tag;
    }

    public Young setTag(String tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public String toString() {
        return "Young{" +
                "tag='" + tag + '\'' +
                '}';
    }
}