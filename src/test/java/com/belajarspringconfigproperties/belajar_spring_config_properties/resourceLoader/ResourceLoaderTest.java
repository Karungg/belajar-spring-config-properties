package com.belajarspringconfigproperties.belajar_spring_config_properties.resourceLoader;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import lombok.Setter;

@SpringBootTest(classes = ResourceLoaderTest.TestApplication.class)
public class ResourceLoaderTest {

    @Autowired
    private TestApplication.SampleResource sampleResource;

    @Test
    void testResource() throws IOException {
        Assertions.assertEquals("Miftah Fadilah", sampleResource.getProperties().trim());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleResource implements ResourceLoaderAware {

            @Setter
            private ResourceLoader resourceLoader;

            public String getProperties() throws IOException {
                Resource resource = resourceLoader.getResource("classpath:text/resource.txt");
                try (var inputStream = resource.getInputStream()) {
                    return new String(inputStream.readAllBytes());
                }
            }
        }
    }
}
