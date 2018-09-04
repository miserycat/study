package springAnnotation.entity;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by shengchao wu on 7/5/2018.
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"springAnnotation.entity.Pink", "springAnnotation.entity.Silver"};
    }
}
