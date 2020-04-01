package me.choi.springcore.spring_annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

class AnnotaionsScannerTest {
    @Test
    public void AnnotationTest() {
        Annotation[] declaredAnnotations = ScannerAnnotation.getDeclaredAnnotations(AnnotationTests.class, false);
        System.out.println(declaredAnnotations[0]);
    }

}