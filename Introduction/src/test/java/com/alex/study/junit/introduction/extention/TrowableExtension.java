package com.alex.study.junit.introduction.extention;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.io.IOException;

public class TrowableExtension implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        // если выпадает такое исключение мы пробрасываем его дальше
        if(throwable instanceof IOException) {
            throw throwable;
        }
    }
}
