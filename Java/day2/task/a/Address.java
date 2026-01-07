package day2.task.a;

public class Address {
    private int pincode;
    String state,city;

    public Address(String city, int pincode, String state) {
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }
}
