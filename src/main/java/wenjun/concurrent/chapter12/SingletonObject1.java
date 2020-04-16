package wenjun.concurrent.chapter12;

import multiThreading.exer.Singleton;

//懒汉式，可以保证线程安全，但是没有lazy load
public class SingletonObject1 {
    private static  SingletonObject1 instance = new SingletonObject1();
    private SingletonObject1() {

    }

    public static SingletonObject1 getInstance() {
        return SingletonObject1.instance;
    }



}
