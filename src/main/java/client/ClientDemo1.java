package client;

import bean.EntityWithMuchAttr;
import bean.MyBeanTest;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by shengchao wu on 6/9/2017.
 */
public class ClientDemo1 {
    public static void main(String[] args) {
/*        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application-context-test.xml"));
        MyBeanTest myBeanTest = (MyBeanTest) bf.getBean("myBeanTest");

        System.out.print(myBeanTest.getTestStr());*/
        EntityWithMuchAttr.Builder builder = new EntityWithMuchAttr.Builder("0001", "jack")
                .address("shanghai")
                .lover("luna");

        EntityWithMuchAttr entity = builder.build();

        System.out.println(entity);

        entity = builder.address("beijing").build();

        System.out.println(entity);


    }
}
