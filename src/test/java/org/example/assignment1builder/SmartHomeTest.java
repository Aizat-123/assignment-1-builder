package org.example.assignment1builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeTest {

    private final Address address1 =
            new Address("Astana", "Mangilik el", 56);

    private final Address address2 =
            new Address("Almaty", "Nazarbayev", 7);

    private final SmartHomeDirector director =
            new SmartHomeDirector();


    // 1. Required name
    @Test
    void nameIsRequired() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .address(address1)
                        .securityLevel("low")
                        .build()
        );
    }


    // 2. Required address
    @Test
    void addressIsRequired() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .name("Test Home")
                        .securityLevel("low")
                        .build()
        );
    }


    // 3. Required security level
    @Test
    void securityLevelIsRequired() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .name("Test Home")
                        .address(address1)
                        .build()
        );
    }


    // 4. Security level must be valid
    @Test
    void securityLevelMustBeValid() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .name("Test Home")
                        .address(address1)
                        .securityLevel("super")
                        .build()
        );
    }


    // 5. Individual constraint:
    // HIGH security requires camera
    @Test
    void highSecurityRequiresCamera() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .name("Secure Home")
                        .address(address1)
                        .securityLevel("high")
                        .enableAlarm()
                        .enableSmartLock()
                        .enableMotionDetector()
                        .build()
        );
    }


    // 6. MEDIUM security requires smart lock and alarm
    @Test
    void mediumSecurityRequiresSmartLockAndAlarm() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .name("Medium Home")
                        .address(address1)
                        .securityLevel("medium")
                        .build()
        );
    }


    // 7. LOW security does not allow camera
    @Test
    void lowSecurityDoesNotAllowCamera() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .name("Low Security Home")
                        .address(address1)
                        .securityLevel("low")
                        .enableCamera()
                        .build()
        );
    }


    // 8. Motion detection requires camera
    @Test
    void motionDetectionRequiresCamera() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .name("Motion Home")
                        .address(address1)
                        .securityLevel("medium")
                        .enableSmartLock()
                        .enableAlarm()
                        .enableMotionDetector()
                        .build()
        );
    }


    // 9. Heating and cooling cannot be enabled together
    @Test
    void heatingAndCoolingCannotBeEnabledTogether() {

        assertThrows(
                IllegalStateException.class,
                () -> new SmartHome.Builder()
                        .name("Climate Home")
                        .address(address1)
                        .securityLevel("low")
                        .enableHeating()
                        .enableCooling()
                        .build()
        );
    }


    // 10. Builder reuse / Product independence
    @Test
    void reusingBuilderDoesNotChangeAlreadyBuiltProduct() {

        SmartHome.Builder builder =
                new SmartHome.Builder();

        SmartHome firstHome =
                builder
                        .name("First Home")
                        .address(address1)
                        .securityLevel("low")
                        .enableHeating()
                        .build();

        SmartHome secondHome =
                builder
                        .name("Second Home")
                        .address(address2)
                        .securityLevel("medium")
                        .enableCooling()
                        .enableSmartLock()
                        .enableAlarm()
                        .build();

        assertEquals("First Home", firstHome.getName());
        assertEquals("low", firstHome.getSecurityLevel());
        assertTrue(firstHome.getEnableHeating());
        assertFalse(firstHome.getEnableCooling());

        assertEquals("Second Home", secondHome.getName());
        assertEquals("medium", secondHome.getSecurityLevel());
        assertFalse(secondHome.getEnableHeating());
        assertTrue(secondHome.getEnableCooling());
    }


    // 11. Basic preset
    @Test
    void basicHomeIsCreatedCorrectly() {

        SmartHome home =
                director.createBasicHome(
                        "Basic Home",
                        address1
                );

        assertEquals("Basic Home", home.getName());
        assertEquals("low", home.getSecurityLevel());

        assertTrue(home.getEnableHeating());
        assertFalse(home.getEnableCooling());

        assertFalse(home.getEnableCamera());
        assertFalse(home.getEnableAlarm());
        assertFalse(home.getEnableSmartLock());
        assertFalse(home.getEnableMotionDetection());
    }


    // 12. Secure preset
    @Test
    void secureHomeIsCreatedCorrectly() {

        SmartHome home =
                director.createSecureHome(
                        "Secure Home",
                        address1
                );

        assertEquals("Secure Home", home.getName());
        assertEquals("high", home.getSecurityLevel());

        assertTrue(home.getEnableHeating());
        assertTrue(home.getEnableCamera());
        assertTrue(home.getEnableAlarm());
        assertTrue(home.getEnableSmartLock());
        assertTrue(home.getEnableMotionDetection());
    }


    // 13. Eco preset
    @Test
    void ecoHomeIsCreatedCorrectly() {

        SmartHome home =
                director.createEcoHome(
                        "Eco Home",
                        address1
                );

        assertEquals("Eco Home", home.getName());
        assertEquals("medium", home.getSecurityLevel());

        assertTrue(home.getEnableCooling());
        assertTrue(home.getEnableEnergyMonitoring());
        assertTrue(home.getEnableSmartLock());
        assertTrue(home.getEnableAlarm());

        assertFalse(home.getEnableHeating());
    }
}