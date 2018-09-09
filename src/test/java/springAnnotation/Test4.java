package springAnnotation;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springAnnotation.aop.MathCalculator;
import springAnnotation.config.MyAopConfiguration;

/**
 * Created by shengchao wu on 7/11/2018.
 */
public class Test4 {

    private AnnotationConfigApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(MyAopConfiguration.class);
    }



    @Test
    public void test1() {
        MathCalculator calculator = (MathCalculator) applicationContext.getBean("mathCalculator");
        calculator.div(10,5);
    }

    @After
    public void tearDown() {
        if (applicationContext != null) {
            applicationContext.close();
        }
    }

}
