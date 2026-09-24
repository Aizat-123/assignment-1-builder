package org.example.assignment1builder;

public class Address {
    private final String city;
    private final String street;
    private final int houseNumber;

    //CONSTRUCTOR
    public Address(String city, String street, int houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    //GETTERS
    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}