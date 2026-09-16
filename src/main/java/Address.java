public class Address {
    private String city;
    private String street;
    private int houseNumber;
    //CONSTRUCTOR
    public Address(String city, String street, int houseNumber){
        this.city=city;
        this.street=street;
        this.houseNumber=houseNumber;
    }
    //GETTERS
    public String getCity(){
        return city;
    }
    public String getStreet(){
        return street;
    }
    public int getHouseNumber(){
        return houseNumber;
    }
    //SETTERS
    public void setCity(String city){
        this.city=city;
    }
    public void setStreet(String street){
        this.street=street;
    }
    public void setHouseNumber(int houseNumber){
        this.houseNumber=houseNumber;
    }
}

/*
* constructor-based implementation and fields, setters and getters implementation. The class has a large number of fields making the code harder to read when instantiating the `SmartHome` object, particularly so many booleans, which are easily mixed up . This approach also suffers from poor extensibility: adding a new field requires modifying the constructor as well as every location where that constructor is called.
* */