package springAnnotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import springAnnotation.condition.LinuxCondition;
import springAnnotation.condition.WindowsCondition;
import springAnnotation.entity.Green;
import springAnnotation.entity.MyImportSelector;
import springAnnotation.entity.Person;
import springAnnotation.entity.Red;
import springAnnotation.scanFilter.MyTypeFilter;

/**
 * Created by shengchao wu on 7/5/2018.
 */

@Configuration
@ComponentScans({
        @ComponentScan(value = "springAnnotation", excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        }),
//        @ComponentScan(value = "springAnnotation", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//        }, useDefaultFilters = false),
//        @ComponentScan(value = "springAnnotation", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
//        }, useDefaultFilters = false),
})
@Import({Green.class, Red.class, MyImportSelector.class, MyImportBeanRegister.class})
public class MyConfiguration {

    @Bean
    @Lazy
    public Person person() {
        System.out.println("person created ...");
        return new Person("jack",34);
    }


    @Bean
    @Conditional({WindowsCondition.class})
    public Person windows() {
        return new Person("windows", 100);
    }

    @Bean
    @Conditional({LinuxCondition.class})
    public Person linux() {
        return new Person("linux", 40);
    }

    @Bean
    public MyFactoryBean myFactoryBean() {
        return new MyFactoryBean();
    }
}
