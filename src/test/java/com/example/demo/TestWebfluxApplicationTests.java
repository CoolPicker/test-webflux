package com.example.demo;

import com.example.demo.controller.TestController;
import com.example.demo.controller.WebfluxController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWebfluxApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

	/*@Test
	public void contextLoads() {
        WebfluxController bean = SpringContext.getBean(WebfluxController.class);
        String s = bean.sayHello();
        System.out.println(s);
    }*/
	@Autowired
    private TestController testController;

    @Test
    public void test(){
        WebfluxController bean = applicationContext.getBean(WebfluxController.class);
        String s = bean.sayHello();
        System.out.println(s+"----lilla");
    }

    @Test
    public void hello(){
        testController.hahha();
    }

}
