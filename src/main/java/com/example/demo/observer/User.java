package com.example.demo.observer;

/**
 * @Author: nya
 * @Description:
 * @Date: Created in 11:42 2018/7/23
 * @Modify by:
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }

}
