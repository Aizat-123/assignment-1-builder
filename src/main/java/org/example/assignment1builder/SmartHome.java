package org.example.assignment1builder;

public class SmartHome {
    private final String name;
    private final Address address;
    private final String securityLevel;
    private final boolean enableHeating ;
    private final boolean enableCooling;
    private final boolean enableCamera;
    private final boolean enableAlarm;
    private final boolean enableSmartLock;
    private final boolean enableMotionDetection;
    private final boolean enableEnergyMonitoring;

    //BUILDER
    public static class Builder{
        private String name;
        private Address address;
        private String securityLevel;
        private boolean enableHeating =false;
        private boolean enableCooling =false;
        private boolean enableCamera =false;
        private boolean enableAlarm =false;
        private boolean enableSmartLock =false;
        private boolean enableMotionDetection =false;
        private boolean enableEnergyMonitoring =false;
        private final String LOW = "low";
        private final String MEDIUM = "medium";
        private final String HIGH = "high";

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
        public Builder enableHeating(){
            this.enableHeating =true;
            return this;
        }
        public Builder enableCooling(){
            this.enableCooling =true;
            return this;
        }
        public Builder enableCamera(){
            this.enableCamera =true;
            return this;
        }
        public Builder enableAlarm(){
            this.enableAlarm =true;
            return this;
        }
        public Builder enableSmartLock(){
            this.enableSmartLock =true;
            return this;
        }
        public Builder enableMotionDetector(){
            this.enableMotionDetection =true;
            return this;
        }
        public Builder enableEnergyMonitoring(){
            this.enableEnergyMonitoring =true;
            return this;
        }
        public SmartHome build(){
            validateRequiredFields();
            validateSecurityLevel();
            validateDevises();
            validateMediumSecurityLevel();
            validateLowSecurityLevel();
            validateHighSecurityLevelEnableAlarm();
            validateHighSecurityLevelEnableCamera();
            validateHighSecurityLevelEnableMotionDetection();
            validateHighSecurityLevelEnableSmartLock();
            SmartHome smartHome= new SmartHome(name,address,securityLevel, enableHeating, enableCooling, enableCamera, enableAlarm, enableSmartLock, enableMotionDetection, enableEnergyMonitoring);
            reset();
            return smartHome;
        }
        private void reset() {
            name = null;
            address = null;
            securityLevel = null;

            enableHeating = false;
            enableCooling = false;
            enableCamera = false;
            enableAlarm = false;
            enableSmartLock = false;
            enableMotionDetection = false;
            enableEnergyMonitoring = false;
        }
        private void validateRequiredFields() {
            if (name == null || name.isBlank()) {
                throw new IllegalStateException("The name of smart home is required");
            }
            if (address == null) {
                throw new IllegalStateException("The address of home is required");
            }
            if (securityLevel == null || securityLevel.isBlank()) {
                throw new IllegalStateException("The security level is required");
            }
        }
        private void validateSecurityLevel() {
            if (!securityLevel.equals(LOW) && !securityLevel.equals(MEDIUM) && !securityLevel.equals(HIGH)) {
                throw new IllegalStateException("The security level must be low/medium/high");
            }
        }
        private void validateHighSecurityLevelEnableAlarm() {
            if (securityLevel.equals(HIGH) && !enableAlarm) {
                throw new IllegalStateException("The high level security requires enabled alarm");
            }
        }
        private void validateHighSecurityLevelEnableCamera() {
            if (securityLevel.equals(HIGH) && !enableCamera) {
                throw new IllegalStateException("The high level security requires enabled camera");
            }
        }
        private void validateHighSecurityLevelEnableSmartLock() {
            if (securityLevel.equals(HIGH) && !enableSmartLock) {
                throw new IllegalStateException("The high level security requires enabled smart lock");
            }
        }
        private void validateHighSecurityLevelEnableMotionDetection() {
            if (securityLevel.equals(HIGH) && !enableMotionDetection) {
                throw new IllegalStateException("The high level security requires enabled motion detection");
            }
        }
        private void validateMediumSecurityLevel() {
            if (securityLevel.equals(MEDIUM) && (!enableSmartLock || !enableAlarm)) {
                throw new IllegalStateException("The medium level security requires enabled smart lock and alarm");
            }
        }
        private void validateLowSecurityLevel(){
            if (securityLevel.equals(LOW) && (enableCamera || enableAlarm || enableMotionDetection)) {
                throw new IllegalStateException("The camera/alarm/motion detection cannot be enabled on low security level");
            }
        }
        private void validateDevises(){
            if(enableMotionDetection && !enableCamera){
                throw new IllegalStateException("The enabled motion detection requires an enabled camera");
            }
            if(enableCooling && enableHeating){
                throw new IllegalStateException("The heating and cooling cannot be enabled at the same time");
            }
        }
    }

    //CONSTRUCTOR
    private SmartHome(String name, Address address, String securityLevel, boolean enableHeating, boolean enableCooling, boolean enableCamera, boolean enableAlarm, boolean enableSmartLock, boolean enableMotionDetection, boolean enableEnergyMonitoring){
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
    public boolean getEnableHeating(){return enableHeating;}
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
}
