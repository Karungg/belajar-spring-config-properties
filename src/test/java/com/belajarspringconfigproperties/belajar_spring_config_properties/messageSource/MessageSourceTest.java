package com.belajarspringconfigproperties.belajar_spring_config_properties.messageSource;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootTest(classes = MessageSourceTest.TestConfiguration.class)
public class MessageSourceTest {

    @SpringBootApplication
    public static class TestConfiguration {
        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasename("my");

            return messageSource;
        }
    }

    @Autowired
    public MessageSourceTest.TestConfiguration testConfiguration;

    @Test
    void testMessageSource() {
        Assertions.assertEquals("Hello Miftah",
                testConfiguration.messageSource().getMessage("hello", new Object[] { "Miftah" }, Locale.getDefault()));
    }

}
