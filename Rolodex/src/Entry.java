/**
 * Created on 1/4/2017, 1:54 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Rolodex
 */

public class Entry {
    String firstName, lastName, address;
    long phoneNum;

    public Entry(String firstName, String lastName, String address, long phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
}
