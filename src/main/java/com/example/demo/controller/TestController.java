package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 */
@RestController
public class TestController {


    @Bean
    public TestService getTest(){
        TestService testService = new TestService();
        return testService;
    }

    @Bean
    public List<TestService> hellos(){
        TestService testService1 = new TestService();
        testService1.setAa("hello first");
        TestService testService2 = new TestService();
        testService2.setAa("hello second");
        TestService testService3 = new TestService();
        testService3.setAa("hello three");
        TestService testService4 = new TestService();
        testService4.setAa("hello four");
        List<TestService> services = new ArrayList<>();
        services.add(testService1);
        services.add(testService2);
        services.add(testService3);
        services.add(testService4);
        return services;
    }

    @GetMapping("/test")
    public void set(){
        getTest().sayHello();
    }

    @Autowired
    List<TestService> hellos;

    @GetMapping("/hah")
    public void hahha(){

        for (TestService service : hellos){
            service.sayHello();
        }
    }


}
