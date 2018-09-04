package springAnnotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springAnnotation.entity.Car;

/**
 * Created by shengchao wu on 7/6/2018.
 */
@Configuration
@ComponentScan(value = "springAnnotation.entity")
public class LifeCycleConfiguration {



    //singleton bean will manage destroy method, prototype bean will not
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car () {
        return new Car();
    }

}
