package com.belajarspringconfigproperties.belajar_spring_config_properties.springBootMessageSource;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = SpringBootMessageSourceTest.TestApplication.class)
public class SpringBootMessageSourceTest {
    @SpringBootApplication
    public static class TestApplication implements MessageSourceAware {
        @Setter
        private MessageSource messageSource;

        public String helloMiftah() {
            return messageSource.getMessage("hello", new Object[] { "Miftah" }, Locale.getDefault());
        }
    }

    @Autowired
    private SpringBootMessageSourceTest.TestApplication sampleTestApplication;

    @Test
    void testSpringBootMessageSourceTest() {
        log.info("Get sampleTestApplication.helloMiftah() : " + sampleTestApplication.helloMiftah());
        Assertions.assertEquals("Hello Miftah", sampleTestApplication.helloMiftah());
    }
}
