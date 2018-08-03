package com.example.demo.observer;
/**
 * 抽象被观察的接口，声明了添加、删除、通知观察者方法
 * @Author: nya
 * @Description:
 * @Date: Created in 11:38 2018/7/23
 * @Modify by:
 */
public interface Observerable {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();

}
