package springAnnotation.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by shengchao wu on 7/6/2018.
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy...");
    }
}
