package com.belajarspringconfigproperties.belajar_spring_config_properties;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

@SpringBootTest
public class ResourceTest {
    @Test
    void testResource() throws IOException {
        var resource = new ClassPathResource("/application.properties");

        Assertions.assertNotNull(resource);

        System.out.println(resource.getPath());
        System.out.println(resource.getFilename());
        System.out.println(resource.getFile().getAbsolutePath());
    }
}
