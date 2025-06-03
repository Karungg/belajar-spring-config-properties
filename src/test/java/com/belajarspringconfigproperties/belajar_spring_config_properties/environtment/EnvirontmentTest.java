package com.belajarspringconfigproperties.belajar_spring_config_properties.environtment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
public class EnvirontmentTest {
    @Autowired
    private Environment environment;

    @Test
    void testEnvirontment() {
        String java_home = environment.getProperty("JAVA_HOME");
        System.out.println(java_home);
    }
}
