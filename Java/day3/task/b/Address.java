package day2.task.b;

// This class represents a physical address and includes a method for string representation.
public class Address {
    private int pincode;
    String state,city;

    // Overridden toString method to provide a string representation of the address details.
    @Override
    public String toString() {
        return "Address{" +
                "pincode=" + pincode +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    // Constructor to initialize the address details.
    public Address(String city, int pincode, String state) {
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }
}