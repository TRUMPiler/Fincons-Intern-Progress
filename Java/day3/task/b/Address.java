package day2.task.b;

public class Address {
    private int pincode;
    String state,city;
    //to String method to print values of all attributes
    @Override
    public String toString() {
        return "Address{" +
                "pincode=" + pincode +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
    // injecting values with parameterized constructor
    public Address(String city, int pincode, String state) {
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }
}
