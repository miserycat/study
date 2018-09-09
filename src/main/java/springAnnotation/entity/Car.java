package springAnnotation.entity;

/**
 * Created by shengchao wu on 7/6/2018.
 */
public class Car{

    public Car() {
        System.out.println("invoke car constructor...");
    }


    public void init() {
        System.out.println("car init...");
    }


    public void destroy() {
        System.out.println("car destroy...");
    }

}
