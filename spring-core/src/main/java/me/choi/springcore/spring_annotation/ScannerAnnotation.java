package me.choi.springcore.spring_annotation;

import org.springframework.util.ConcurrentReferenceHashMap;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Map;

public class ScannerAnnotation {
    private static final Map<AnnotatedElement, Annotation[]> declaredAnnotaionCached =
            new ConcurrentReferenceHashMap<>();


    static Annotation[] getDeclaredAnnotations(AnnotatedElement source, boolean defensive) {
        boolean cached = false;
        Annotation[] annotations = declaredAnnotaionCached.get(source);
        if (annotations != null) {
            cached = true;
        } else {
            annotations = source.getDeclaredAnnotations();
            if (annotations.length != 0 ) {
                declaredAnnotaionCached.put(source, annotations);
                cached = true;
            }
        }
        if (!cached) {
            return annotations;
        }
        return annotations.clone();
    }
}
