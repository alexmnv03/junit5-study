package com.alex.study.junit.introduction;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

public class TestLauncher {
    public static void main(String[] args) {
        var launcher = LauncherFactory.create();
        // Статистика по тестам
        var summaryListner = new SummaryGeneratingListener();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                // Тут указываем где искать наши тесты
                .selectors(DiscoverySelectors.selectClass(UserServiceTest.class))
                // или укажем пакет
                .selectors(DiscoverySelectors.selectPackage("com.alex.study.junit.introduction"))
                .build();
        launcher.execute(request, summaryListner);

        try (var writer = new PrintWriter(System.out)) {
            summaryListner.getSummary().printTo(writer);
        }
    }
}
