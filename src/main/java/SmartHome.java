public class SmartHome {
    private String name;
    private Address address;
    private String securityLevel;
    private boolean enableHeating;
    private boolean enableCooling;
    private boolean enableCamera;
    private boolean enableAlarm;
    private boolean enableSmartLock;
    private boolean enableMotionDetection;
    private boolean enableEnergyMonitoring;

    //BUILDER
    public static class Builder{
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

        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder address(Address address){
            this.address=address;
            return this;
        }
        public Builder securityLevel(String securityLevel){
            this.securityLevel=securityLevel;
            return this;
        }
        public Builder heatingEnabled(boolean heatingEnabled){
            this.heatingEnabled=heatingEnabled;
            return this;
        }
        public Builder coolingEnabled(boolean coolingEnabled){
            this.coolingEnabled=coolingEnabled;
            return this;
        }
        public Builder cameraEnabled(boolean cameraEnabled){
            this.cameraEnabled=cameraEnabled;
            return this;
        }
        public Builder alarmEnabled(boolean alarmEnabled){
            this.alarmEnabled=alarmEnabled;
            return this;
        }
        public Builder smartLockEnabled(boolean smartLockEnabled){
            this.smartLockEnabled=smartLockEnabled;
            return this;
        }
        public Builder motionDetectionEnabled(boolean motionDetectionEnabled){
            this.motionDetectionEnabled=motionDetectionEnabled;
            return this;
        }
        public Builder energyMonitoringEnabled(boolean energyMonitoringEnabled){
            this.energyMonitoringEnabled=energyMonitoringEnabled;
            return this;
        }
        public SmartHome build(){
            validate();
            return new SmartHome(name,address,securityLevel,heatingEnabled,coolingEnabled,cameraEnabled,alarmEnabled,smartLockEnabled,motionDetectionEnabled,energyMonitoringEnabled);
        }
        private void validate(){
            if(name==null && name.isBlank()){
                throw new IllegalStateException("The name of smart home is required");
            }
            if(address==null){
                throw new IllegalStateException("The address of home is required");
            }
            if(securityLevel==null && securityLevel.isBlank()){
                throw new IllegalStateException("The security level is required");
            }
            if(!securityLevel.equals("low") && !securityLevel.equals("medium") && !securityLevel.equals("high")){
                throw new IllegalStateException("The security level must be low/medium/high");
            }
            if (securityLevel.equals("high") && !alarmEnabled) {
                throw new IllegalStateException("The high level security requires enabled alarm");
            }
            if (securityLevel.equals("high") && !cameraEnabled) {
                throw new IllegalStateException("The high level security requires enabled camera");
            }
            if (securityLevel.equals("high") && !smartLockEnabled) {
                throw new IllegalStateException("The high level security requires enabled smart lock");
            }
            if (securityLevel.equals("high") && !motionDetectionEnabled) {
                throw new IllegalStateException("The high level security requires enabled motion detection");
            }
            if (securityLevel.equals("medium") && (!smartLockEnabled || !alarmEnabled)) {
                throw new IllegalStateException("The medium level security requires enabled smart lock and alarm");
            }
            if (securityLevel.equals("low") && (cameraEnabled || alarmEnabled ||motionDetectionEnabled)){
                throw new IllegalStateException("The camera/alarm/motion detection cannot be enabled on low security level");
            }
            if(motionDetectionEnabled && !cameraEnabled){
                throw new IllegalStateException("The enabled motion detection requires an enabled camera");
            }
            if(coolingEnabled && heatingEnabled){
                throw new IllegalStateException("The heating and cooling cannot be enabled at the same time");
            }
        }
    }

    //CONSTRUCTOR
    public SmartHome(String name, Address address, String securityLevel, boolean enableHeating, boolean enableCooling, boolean enableCamera, boolean enableAlarm, boolean enableSmartLock, boolean enableMotionDetection, boolean enableEnergyMonitoring){
        this.name=name;
        this.address=address;
        this.securityLevel=securityLevel;
        this.enableHeating = enableHeating;
        this.enableCooling = enableCooling;
        this.enableCamera = enableCamera;
        this.enableAlarm = enableAlarm;
        this.enableSmartLock = enableSmartLock;
        this.enableMotionDetection = enableMotionDetection;
        this.enableEnergyMonitoring = enableEnergyMonitoring;
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
    public boolean getEnableCooling(){
        return enableCooling;
    }
    public boolean getEnableCamera(){
        return enableCamera;
    }
    public boolean getEnableAlarm(){
        return enableAlarm;
    }
    public boolean getEnableSmartLock(){
        return enableSmartLock;
    }
    public boolean getEnableMotionDetection(){
        return enableMotionDetection;
    }public boolean getEnableEnergyMonitoring(){
        return enableEnergyMonitoring;
    }
    //SETTERS
    public void setName(String name){
        this.name=name;
    }
    public void setSecurityLevel(String securityLevel){
        this.securityLevel=securityLevel;
    }
    public void setEnableCooling(boolean enableCooling){
        this.enableCooling = enableCooling;
    }
    public void setEnableCamera(boolean enableCamera){
        this.enableCamera = enableCamera;
    }
    public void setEnableAlarm(boolean enableAlarm){
        this.enableAlarm = enableAlarm;
    }
    public void setEnableSmartLock(boolean enableSmartLock){
        this.enableSmartLock = enableSmartLock;
    }
    public void setEnableMotionDetection(boolean enableMotionDetection){
        this.enableMotionDetection = enableMotionDetection;
    }
    public void setEnableEnergyMonitoring(boolean enableEnergyMonitoring){
        this.enableEnergyMonitoring = enableEnergyMonitoring;
    }
}
