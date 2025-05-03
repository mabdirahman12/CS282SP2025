import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Contact other) {
        return this.getFullName().compareToIgnoreCase(other.getFullName());
    }

    @Override
    public String toString() {
        return "Name: " + getFullName() + "\nAddress: " + address + "\nPhone: " + phoneNumber;
    }

    // Getters and Setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
