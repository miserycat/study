package springAnnotation.config;

import org.springframework.beans.factory.FactoryBean;
import springAnnotation.entity.FactoryCreatedBean;

/**
 * Created by shengchao wu on 7/5/2018.
 */
public class MyFactoryBean implements FactoryBean<FactoryCreatedBean> {
    @Override
    public FactoryCreatedBean getObject() throws Exception {
        return new FactoryCreatedBean();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryCreatedBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
