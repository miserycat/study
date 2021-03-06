package springAnnotation.condition;


import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by shengchao wu on 7/5/2018.
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        ClassLoader classLoader = conditionContext.getClassLoader();
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        Environment environment = conditionContext.getEnvironment();
        return environment.getProperty("os.name").toUpperCase().contains("WINDOWS");
    }
}
