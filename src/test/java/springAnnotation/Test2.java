package springAnnotation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import springAnnotation.config.MyConfiguration2;
import springAnnotation.entity.AwareEntity;
import springAnnotation.entity.Boss;
import springAnnotation.entity.DatabaseConfig;
import springAnnotation.service.PersonService;

/**
 * Created by shengchao wu on 7/6/2018.
 */
public class Test2 {
    private AnnotationConfigApplicationContext ac;

    @Before
    public void setUp() {
        ac = new AnnotationConfigApplicationContext(MyConfiguration2.class);
    }

    @Test
    public void testValue() {
        DatabaseConfig dataBaseConfig = (DatabaseConfig) ac.getBean("databaseConfig");

        System.out.println(dataBaseConfig);

        ConfigurableEnvironment environment = ac.getEnvironment();

        System.out.println(environment.getProperty("jdbc.user"));
    }

    @Test
    public void testAutoWired() {
        PersonService personService = (PersonService) ac.getBean("personService");

        System.out.println(personService);

        Boss boss = (Boss) ac.getBean("boss");

        System.out.println(boss);
    }


    @Test
    public void testAware() {
        AwareEntity awareEntity = (AwareEntity) ac.getBean("awareEntity");
    }



    @After
    public void tearDown() {
        if (ac != null) {
            ac.close();
        }
    }
}
