package springAnnotation.entity;

import org.springframework.stereotype.Component;

/**
 * Created by shengchao wu on 7/6/2018.
 */

@Component
public class Boss {

    private Car car;

    //有参构造器上注入依赖Autowired可以省略
    public Boss(Car car) {
        System.out.println("Boss constructor... car: " + car);
        this.car = car;
    }
}
