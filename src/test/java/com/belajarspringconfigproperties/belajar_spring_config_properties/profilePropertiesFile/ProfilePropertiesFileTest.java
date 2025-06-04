package com.belajarspringconfigproperties.belajar_spring_config_properties.profilePropertiesFile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import lombok.Getter;

@SpringBootTest
@ActiveProfiles({ "production", "test" })
public class ProfilePropertiesFileTest {

    // @SpringBootApplication
    // public static class TestApplicationProperties {

    // @Component
    // @Getter
    // public static class ProfileProperties {
    // @Value("${profile.default}")
    // private String defaultProfile;

    // @Value("${profile.production}")
    // private String productionProfile;

    // @Value("${profile.test}")
    // private String testProfile;
    // }

    // }

    // @Autowired
    // private TestApplicationProperties.ProfileProperties profile;

    // @Test
    // void testProfile() {
    // Assertions.assertEquals("Default", profile.getDefaultProfile());
    // Assertions.assertEquals("Production", profile.getProductionProfile());
    // Assertions.assertEquals("Test", profile.getTestProfile());
    // }

}
