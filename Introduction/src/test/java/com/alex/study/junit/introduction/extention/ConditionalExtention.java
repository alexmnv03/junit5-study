package com.alex.study.junit.introduction.extention;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ConditionalExtention implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        // Тут мы можем определить стоти ли вызывать наш тест, например если свойство skip не
        // равно Null, то мы пропускаем наш тест
        return System.getProperty("skip") != null
                ? ConditionEvaluationResult.disabled("test is skipt")
                : ConditionEvaluationResult.enabled("enable by defailt");
    }
}
