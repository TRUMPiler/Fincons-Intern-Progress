package day2.task.a;

// This class represents a physical address with city, pincode, and state.
public class Address {
    private int pincode;
    String state,city;

    // Constructor to initialize the address details.
    public Address(String city, int pincode, String state) {
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }
}