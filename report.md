Part E-CLEAN CODE
1. I changed the names of fields to more meaningful names. 
Before:
    private boolean heatingEnabled;
    private boolean coolingEnabled;
    private boolean cameraEnabled;
    private boolean alarmEnabled;
    private boolean smartLockEnabled;
    private boolean motionDetectionEnabled;
    private boolean energyMonitoringEnabled;
After:
    private boolean enableHeating =false;
    private boolean enableCooling =false;
    private boolean enableCamera =false;
    private boolean enableAlarm =false;
    private boolean enableSmartLock =false;
    private boolean enableMotionDetection =false;
    private boolean enableEnergyMonitoring =false;
1.1 I also set initial values to `false` so that the builder methods would not require arguments.
    Calling a method changes the value to `true`.
Before:
   public Builder energyMonitoringEnabled(boolean energyMonitoringEnabled){
      this.energyMonitoringEnabled=energyMonitoringEnabled;
      return this;
   }
   public Builder motionDetectionEnabled(boolean motionDetectionEnabled){
      this.motionDetectionEnabled=motionDetectionEnabled;
      return this;
   }  
   public Builder smartLockEnabled(boolean smartLockEnabled){
      this.smartLockEnabled=smartLockEnabled;
      return this;
   }
   public Builder alarmEnabled(boolean alarmEnabled){
      this.alarmEnabled=alarmEnabled;
      return this;
   }
   public Builder cameraEnabled(boolean cameraEnabled){
      this.cameraEnabled=cameraEnabled;
      return this;
   }
   public Builder coolingEnabled(boolean coolingEnabled){
      this.coolingEnabled=coolingEnabled;
      return this;
   }
   public Builder heatingEnabled(boolean heatingEnabled){
      this.heatingEnabled=heatingEnabled;
      return this;
   }
After:
   public Builder enableEnergyMonitoring(){
   this.enableEnergyMonitoring =true;
   return this;
   }
   public Builder enableMotionDetector(){
   this.enableMotionDetection =true;
   return this;
   }
   public Builder enableSmartLock(){
   this.enableSmartLock =true;
   return this;
   }
   public Builder enableAlarm(){
   this.enableAlarm =true;
   return this;
   }
   public Builder enableCamera(){
   this.enableCamera =true;
   return this;
   }
   public Builder enableCooling(){
   this.enableCooling =true;
   return this;
   }
   public Builder enableHeating(){
   this.enableHeating =true;
   return this;
   }
2. I added `LOW`, `MEDIUM`, and `HIGH` constants,
thereby eliminating "magic values" (such as "high", "low", and "medium")
and removing redundant security level checks.
Before:
   if(!securityLevel.equals("low") && !securityLevel.equals("medium") && !securityLevel.equals("high")){...}
   if (securityLevel.equals("high") && !alarmEnabled){...}
   if (securityLevel.equals("high") && !cameraEnabled){...}
After:
    private final String LOW = "low";
    private final String MEDIUM = "medium";
    private final String HIGH = "high";
    if (!securityLevel.equals(LOW) && !securityLevel.equals(MEDIUM) && !securityLevel.equals(HIGH)){...}
    if (securityLevel.equals(HIGH) && !enableAlarm){...}
    if (securityLevel.equals(HIGH) && !enableCamera){...}
   3. I broke the `validate()` function down into small methods, 
      each performing a single task and corresponding to a specific level of abstraction.
   Before:
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
          throw new IllegalStateException( "The security level must be low/medium/high");
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
   After:
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
Part F - DESIGN DECISION
   Decision:
      The validation belong to the Builder because of several reasons. 
      The SmartHome class have many fields and every security level requires different devices (high level requires enabled camera, alarm, smart lock и motion detection at the same time). 
      So I decided to validate these inside Builder before initializing the SmartHome object. I also chose the Builder pattern because the Builder is responsible 
      for assembling the configuration and prevents the creation of an object from an invalid set of parameters. 
      Therefore, build() serves as the single point of validation prior to Product creation.
   Alternative:
      The alternative may be putting the validation in the SmartHome constructor, then the product is responsible for checking all construction parameteres itself.
   Reasoning: 
      Builder is responsible for collecting the parameters, that required to construct a SmartHome and can reject an invalid combination before the object is initialized.
   Decision:
      The SmartHome product is immutable. I deleted the setters and made the Address also immutable because the SmartHomethe contain address field. 
      The constructor is made private so that SmartHome objects are created through the Builder. 
   Alternative: 
      An alternative may be to make the SmartHome object mutable by providing its setters to set properties.
   Reasoning:
      I rejected alternative variant because allowing setters would make it possible to change the SmartHome configuration after 
      construction and potentially create an invalid state. For example, changing the security level without enabling all required devices could 
      violate the configuration rules. Making SmartHome immutable means that the object is fully configured and validated when it is created, 
      and its state cannot be changed afterwards.
   
    
    
    
    
    
    