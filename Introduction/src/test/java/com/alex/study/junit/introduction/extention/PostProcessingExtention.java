package com.alex.study.junit.introduction.extention;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

public class PostProcessingExtention implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {
        System.out.println("postProcessTestInstance");
        var declareFiled = o.getClass().getDeclaredFields();
        for (Field field: declareFiled) {
            if (field.isAnnotationPresent(Autowired.class));
            System.out.println("аннотация найдена");
        }
    }
}
