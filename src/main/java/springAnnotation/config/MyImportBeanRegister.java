package springAnnotation.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import springAnnotation.entity.Rainbow;

/**
 * Created by shengchao wu on 7/5/2018.
 */
public class MyImportBeanRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (beanDefinitionRegistry.containsBeanDefinition("springAnnotation.entity.Green")
                && beanDefinitionRegistry.containsBeanDefinition("springAnnotation.entity.Red")) {
            RootBeanDefinition rainbow = new RootBeanDefinition(Rainbow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainbow", rainbow);
        }

    }
}
