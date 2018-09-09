package springAnnotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springAnnotation.config.MyProfileConfiguration;

/**
 * Created by shengchao wu on 7/6/2018.
 */
public class Test3 {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void setUp() {
        ac = new AnnotationConfigApplicationContext(MyProfileConfiguration.class);
    }


    @Test
    public void testProfile1() {
        // -Dspring.profiles.active=test
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }


    @Test
    public void testProfile2() {
        ac = new AnnotationConfigApplicationContext();
        ac.getEnvironment().setActiveProfiles("test", "dev");
        ac.register(MyProfileConfiguration.class);
        ac.refresh();
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }


    @After
    public void tearDown() {
        if (ac != null) {
            ac.close();
        }
    }

}
