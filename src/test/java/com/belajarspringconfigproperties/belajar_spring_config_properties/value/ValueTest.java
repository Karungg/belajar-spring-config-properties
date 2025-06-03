package com.belajarspringconfigproperties.belajar_spring_config_properties.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import lombok.Getter;

@SpringBootTest(classes = ValueTest.TestApplication.ApplicationProperties.class)
public class ValueTest {
    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class ApplicationProperties {

            @Value("${spring.application.name}")
            private String name;

            @Value("${spring.application.version}")
            private Integer version;

            @Value("${spring.application-mode}")
            private Boolean mode;
        }

    }

    @Autowired
    private ValueTest.TestApplication.ApplicationProperties applicationProperties;

    @Test
    void valueTest() {
        String applicationName = applicationProperties.getName();
        Integer applicationVersion = applicationProperties.getVersion();
        Boolean applicationMode = applicationProperties.getMode();

        Assertions.assertEquals("belajar-spring-config-properties", applicationName);
        Assertions.assertEquals(1, applicationVersion);
        Assertions.assertEquals(false, applicationMode);
    }
}
