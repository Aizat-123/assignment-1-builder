public class SmartHomeDirector {
    public SmartHome createBasicHome(String name, Address address){
        return new SmartHome.Builder().name(name).address(address).enableHeating().securityLevel("low").build();
    }
    public SmartHome createSecureHome(String name, Address address){
        return new SmartHome.Builder().name(name).address(address).enableHeating().securityLevel("high").enableSmartLock().enableMotionDetector().enableCamera().enableAlarm().build();
    }
    public SmartHome createEcoHome(String name, Address address){
        return new SmartHome.Builder().name(name).address(address).securityLevel("medium").enableCooling().enableEnergyMonitoring().enableSmartLock().enableAlarm().build();
    }
}
