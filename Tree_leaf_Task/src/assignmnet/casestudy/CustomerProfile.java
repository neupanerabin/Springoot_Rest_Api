package assignmnet.casestudy;


/*
 * @author : rabin
 */

import java.util.UUID;

public class CustomerProfile {

    private final int customerId;
    private final UUID newCustomerId;
    private final String name;
    private final String address;
    private final long rfidNumber;
    private final String joinedDate;

    //Constructors
    public CustomerProfile(int customerId, UUID newCustomerId, String name, String address, long rfidNumber, String joinedDate) {
        this.customerId = customerId;
        this.newCustomerId = newCustomerId;
        this.name = name;
        this.address = address;
        this.rfidNumber = rfidNumber;
        this.joinedDate = joinedDate;

    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public UUID getNewCustomerId() {
        return newCustomerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getRfidNumber() {
        return rfidNumber;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "customerId=" + customerId +
                ", newCustomerId=" + newCustomerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rfidNumber=" + rfidNumber +
                ", joinedDate='" + joinedDate + '\'' +
                '}';
    }



}
