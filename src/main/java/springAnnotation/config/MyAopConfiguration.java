package springAnnotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springAnnotation.aop.LogAspect;
import springAnnotation.aop.MathCalculator;

/**
 * Created by shengchao wu on 7/10/2018.
 */

@Configuration
@ComponentScan(value = "springAnnotation.aop.*")
public class MyAopConfiguration {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
