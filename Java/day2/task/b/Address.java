package day2.task.b;

public class Address {
    private int pincode;
    String state,city;

    @Override
    public String toString() {
        return "Address{" +
                "pincode=" + pincode +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Address(String city, int pincode, String state) {
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }
}
