package com.belajarspringconfigproperties.belajar_spring_config_properties.propertySource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

@SpringBootTest
public class PropertySourceTest {

    @SpringBootApplication
    @PropertySource("classpath:/sample.properties")
    public static class TestApplication {

        @Component
        @Getter
        public static class SampleProperties {

            @Value("${spring.sample.name}")
            private String name;

            @Value("${spring.sample.version}")
            private Integer version;
        }

    }

    @Autowired
    private PropertySourceTest.TestApplication.SampleProperties sampleProperties;

    @Test
    void testSampleProperties() {
        String sampleName = sampleProperties.getName();
        Integer sampleVersion = sampleProperties.getVersion();

        Assertions.assertEquals("sample-project", sampleName);
        Assertions.assertEquals(1, sampleVersion);
    }

}