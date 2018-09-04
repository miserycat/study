package springAnnotation.entity;

import org.springframework.stereotype.Component;

/**
 * Created by shengchao wu on 7/6/2018.
 */

@Component
public class Boss {

    private Car car;

    //�вι�������ע������Autowired����ʡ��
    public Boss(Car car) {
        System.out.println("Boss constructor... car: " + car);
        this.car = car;
    }
}
