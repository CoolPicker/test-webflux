package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BossController {


    public void sayHi(){
        System.out.println("hi");
    }
}
