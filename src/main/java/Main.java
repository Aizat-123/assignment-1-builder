public class Main {
    public static void main(String[] args){
        Address address= new Address("Astana", "Respublika", 32);
        SmartHome home1=new SmartHome.Builder().name("My smart home").address(address).securityLevel("low").alarmEnabled(false).cameraEnabled(false).coolingEnabled(false).heatingEnabled(true).energyMonitoringEnabled(true).motionDetectionEnabled(false).smartLockEnabled(true).build();
        System.out.println(home1.getName()+"  "+home1.getSecurityLevel());
        System.out.println(address.getCity()+"  "+address.getStreet()+"  "+address.getHouseNumber());
    }
}
