package com.belajarspringconfigproperties.belajar_spring_config_properties.valueSystemVariable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import lombok.Getter;

@SpringBootTest(classes = ValueSystemVariableTest.TestApplication.SystemProperties.class)
public class ValueSystemVariableTest {

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class SystemProperties {

            @Value("${JAVA_HOME}")
            private String javaHome;

        }

    }

    @Autowired
    private TestApplication.SystemProperties systemProperties;

    @Test
    void testSystemProperties() {
        String javaHome = systemProperties.getJavaHome();

        Assertions.assertEquals("${JAVA_HOME}", javaHome);
    }

}
