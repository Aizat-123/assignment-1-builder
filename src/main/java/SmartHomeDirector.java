public class SmartHomeDirector {
    public SmartHome createBasicHome(String name, Address address){
        return new SmartHome.Builder().name(name).address(address).heatingEnabled(true).securityLevel("low").build();
    }
    public SmartHome createSecureHome(String name, Address address){
        return new SmartHome.Builder().name(name).address(address).heatingEnabled(true).securityLevel("high").smartLockEnabled(true).motionDetectionEnabled(true).cameraEnabled(true).alarmEnabled(true).build();
    }
    public SmartHome createEcoHome(String name, Address address){
        return new SmartHome.Builder().name(name).address(address).securityLevel("medium").coolingEnabled(true).energyMonitoringEnabled(true).smartLockEnabled(true).alarmEnabled(true).build();
    }
}
