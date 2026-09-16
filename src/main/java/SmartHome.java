public class SmartHome {
    private String name;
    private Address address;
    private String securityLevel;
    private boolean heatingEnabled;
    private boolean coolingEnabled;
    private boolean cameraEnabled;
    private boolean alarmEnabled;
    private boolean smartLockEnabled;
    private boolean motionDetectionEnabled;
    private boolean energyMonitoringEnabled;
    //CONSTRUCTOR
    public SmartHome(String name, Address address, String securityLevel, boolean heatingEnabled, boolean coolingEnabled, boolean cameraEnabled, boolean alarmEnabled, boolean smartLockEnabled, boolean motionDetectionEnabled, boolean energyMonitoringEnabled){
        this.name=name;
        this.address=address;
        this.securityLevel=securityLevel;
        this.heatingEnabled=heatingEnabled;
        this.coolingEnabled=coolingEnabled;
        this.cameraEnabled=cameraEnabled;
        this.alarmEnabled=alarmEnabled;
        this.smartLockEnabled=smartLockEnabled;
        this.motionDetectionEnabled=motionDetectionEnabled;
        this.energyMonitoringEnabled=energyMonitoringEnabled;
    }
    //GETTERS
    public String getName(){
        return name;
    }
    public Address getAddress() {
        return address;
    }
    public String getSecurityLevel(){
        return securityLevel;
    }
    public boolean getCoolingEnabled(){
        return coolingEnabled;
    }
    public boolean getCameraEnabled(){
        return cameraEnabled;
    }
    public boolean getAlarmEnabled(){
        return alarmEnabled;
    }
    public boolean getSmartLockEnabled(){
        return smartLockEnabled;
    }
    public boolean getMotionDetectionEnabled(){
        return motionDetectionEnabled;
    }public boolean getEnergyMonitoringEnabled(){
        return energyMonitoringEnabled;
    }
    //SETTERS
    public void setName(String name){
        this.name=name;
    }
    public void setSecurityLevel(String securityLevel){
        this.securityLevel=securityLevel;
    }
    public void setCoolingEnabled(boolean coolingEnabled){
        this.coolingEnabled=coolingEnabled;
    }
    public void setCameraEnabled(boolean cameraEnabled){
        this.cameraEnabled=cameraEnabled;
    }
    public void setAlarmEnabled(boolean alarmEnabled){
        this.alarmEnabled=alarmEnabled;
    }
    public void setSmartLockEnabled(boolean smartLockEnabled){
        this.smartLockEnabled=smartLockEnabled;
    }
    public void setMotionDetectionEnabled(boolean motionDetectionEnabled){
        this.motionDetectionEnabled=motionDetectionEnabled;
    }
    public void setEnergyMonitoringEnabled(boolean energyMonitoringEnabled){
        this.energyMonitoringEnabled=energyMonitoringEnabled;
    }
}
