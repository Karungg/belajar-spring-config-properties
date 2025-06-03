package com.belajarspringconfigproperties.belajar_spring_config_properties.applicationProperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import lombok.Setter;

@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {
    @SpringBootApplication
    public static class TestApplication {
        @Setter
        private Environment environment;
    }

    @Autowired
    private Environment environment;

    @Test
    void testApplicationProperties() {
        String message = environment.getProperty("spring.application.name");
        Assertions.assertEquals("belajar-spring-config-properties", message);
    }

}
