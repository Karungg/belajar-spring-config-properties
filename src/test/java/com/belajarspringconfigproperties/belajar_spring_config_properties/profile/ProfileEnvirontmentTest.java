package com.belajarspringconfigproperties.belajar_spring_config_properties.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import lombok.Getter;
import lombok.Setter;

@SpringBootTest(classes = ProfileEnvirontmentTest.TestApplication.TestApplicationEnvirontment.class)
@ActiveProfiles({ "production", "local" })
public class ProfileEnvirontmentTest {

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class TestApplicationEnvirontment implements EnvironmentAware {

            @Setter
            private Environment environment;

            public String[] getActiveProfiles() {
                return environment.getActiveProfiles();
            }
        }

    }

    @Autowired
    private ProfileEnvirontmentTest.TestApplication.TestApplicationEnvirontment environtment;

    @Test
    void testGetActiveProfile() {
        Assertions.assertArrayEquals(new String[] { "production", "local" }, environtment.getActiveProfiles());
    }

}
