package com.belajarspringconfigproperties.belajar_spring_config_properties.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfileTest.TestApplication.class)
@ActiveProfiles({ "production" })
public class ProfileTest {

    public interface SayHello {
        String sayHello(String name);
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Profile({ "local" })
        public static class TestLocalProfile implements SayHello {
            @Override
            public String sayHello(String name) {
                return "Hello local " + name;
            }
        }

        @Component
        @Profile({ "production" })
        public static class TestProductionProfile implements SayHello {
            @Override
            public String sayHello(String name) {
                return "Hello production " + name;
            }
        }

    }

    @Autowired
    private ProfileTest.SayHello sayHello;

    @Test
    void testLocalProfile() {
        Assertions.assertNotSame("Hello local Miftah", sayHello.sayHello("Miftah"));
    }

    @Test
    void testProductionProfile() {
        Assertions.assertEquals("Hello production Miftah", sayHello.sayHello("Miftah"));
    }

}
