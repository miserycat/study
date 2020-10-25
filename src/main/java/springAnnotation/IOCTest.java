package springAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springAnnotation.config.MyIOCConfiguration;

public class IOCTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyIOCConfiguration.class);
        IndexService service = applicationContext.getBean(IndexService.class);
        service.service();
        IndexService service1 = applicationContext.getBean(IndexService.class);
        service1.service();
        IndexService service2 = applicationContext.getBean(IndexService.class);
        service2.service();

    }
}
