This project is a Smart Home configuration system implemented using the Builder design pattern in Java.
A SmartHome class contains:
    name
    address
    security level
    heating
    cooling
    camera
    alarm
    smart lock
    motion detection
    energy monitoring
    Address is a separate value object used by SmartHome.
SmartHome.Builder is used to create SmartHome objects step by step. For example:
    SmartHome home = new SmartHome.Builder()
    .name("My Home")
    .address(address)
    .securityLevel("medium")
    .enableCooling()
    .enableSmartLock()
    .enableAlarm()
    .build();
The Builder also checks whether the selected configuration is valid before creating the object by Validation methods.
Validation methods checks that:
    name, address and security level are required;
    security level can be low, medium or high;
    HIGH security requires a camera, alarm, smart lock and motion detection;
    MEDIUM security requires a smart lock and alarm;
    LOW security does not allow a camera, alarm or motion detection;
    motion detection requires a camera;
    heating and cooling cannot be enabled at the same time.
SmartHomeDirector contains three predefined configurations:
    Basic Home
    Secure Home
    Eco Home
The project contains 13 automated tests.
The tests check:
    required fields;
    valid security levels;
    security-level restrictions;
    device dependencies;
    heating and cooling conflict;
    Builder reuse;
    independence of already created Smart Home objects;
    Basic, Secure and Eco configurations.
