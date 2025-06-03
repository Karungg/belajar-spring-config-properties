package com.belajarspringconfigproperties.belajar_spring_config_properties.testPropertySource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import lombok.Getter;

@SpringBootTest(classes = PropertySourceTest.TestApplication.TestProperties.class)
@TestPropertySources(@TestPropertySource("classpath:/test.properties"))
public class PropertySourceTest {

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class TestProperties {

            @Value("${spring.test.name}")
            private String name;

            @Value("${spring.test.version}")
            private Integer version;

        }

    }

    @Autowired
    private TestApplication.TestProperties testProperties;

    @Test
    void testProperties() {
        Assertions.assertEquals("test-project", testProperties.getName());
        Assertions.assertEquals(1, testProperties.getVersion());
    }

}
