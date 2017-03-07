
/**
 * Created on 1/4/2017, 1:54 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Rolodex
 */
public class Entry implements Comparable<Object> {

    private String firstName, lastName, address;
    private long phoneNum;

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

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Entry) {
            return ((Entry) o).lastName.compareTo(this.lastName);
        } else {
            throw new UnsupportedOperationException("Cannot compare.");
        }
    }
}
