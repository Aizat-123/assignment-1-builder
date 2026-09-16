public class Main {
    public static void main(String[] args){
        Address address1= new Address("Almaty", "Nazarbayev", 7);
        Address address2=new Address("Karaganda", "Buhar-Zhyrau", 11);
        Address address3=new Address("Astana", "Mangilik el", 56);
        SmartHomeDirector director=new SmartHomeDirector();
        SmartHome basicHome=director.createBasicHome("it's basic home", address1);
        SmartHome secureHome=director.createSecureHome("it's secure home", address2);
        SmartHome ecoHome= director.createEcoHome("it's eco home", address3);
    }
}
