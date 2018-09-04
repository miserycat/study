package springAnnotation;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import springAnnotation.config.MyConfiguration;
import springAnnotation.entity.Car;
import springAnnotation.entity.Cat;
import springAnnotation.entity.Person;

/**
 * Created by shengchao wu on 7/5/2018.
 */
public class Test1 {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);

    @Test
    public void test1() {
        System.out.println("init ApplicationContext...");

        Person person1 = (Person) ac.getBean("person");
        Person person2 = (Person) ac.getBean("person");
        System.out.println(person1 == person2);
    }


    @Test
    public void test2() {
        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @Test
    public void test3() {
        Object myFactoryBean = ac.getBean("myFactoryBean");
        System.out.println(myFactoryBean.getClass());
    }


    @Test
    public void testLifeStyle() {
        Car car = (Car) ac.getBean("car");
//        System.out.println("car create finished...");
        ac.close();
    }


}
