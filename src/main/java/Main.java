public class Main {
    public static void main(String[] args){
        Address address= new Address("Astana", "Respublika", 32);
        SmartHome home1=new SmartHome("my smart home",address,"medium",true,false,true,false,true,false,true);
        System.out.println(home1.getName()+"  "+home1.getCameraEnabled());
        System.out.println(address.getCity()+"  "+address.getStreet());
    }
}
