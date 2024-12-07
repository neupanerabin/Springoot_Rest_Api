package assignmnet.casestudy;


/*
 * @author : rabin
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer_ProfileUpdate {
    public static List<CustomerProfile> updateProfile(List<CustomerProfile> existingProfiles, CustomerProfile newCustomer) {
        List<CustomerProfile> updatedProfiles = new ArrayList<>();

        // Update existing profiles with the UUID customer IDs
        for (CustomerProfile profile : existingProfiles) {
            UUID newUuid = UUID.randomUUID();       // Generate random UUID
            CustomerProfile updatedProfile = new CustomerProfile(
                    profile.getCustomerId(),
                    newUuid,
                    profile.getName(),
                    profile.getAddress(),
                    profile.getRfidNumber(),
                    profile.getJoinedDate()

            );
            updatedProfiles.add(updatedProfile);

        }
        // If a new customer is provided, add it to the collection
        if (newCustomer != null) {
            updatedProfiles.add(newCustomer);

        }
        return updatedProfiles;
    }

    public static void main(String[] args) {
        // Sample existing profiles
        List<CustomerProfile> existingProfiles = new ArrayList<>();
        existingProfiles.add(new CustomerProfile(1002, null, "Rabin", "03 Baniyatar", 2003, "2024-12-01"));
        existingProfiles.add(new CustomerProfile(1003, null, "Sampurna", "456 Sitapailat", 2004, "2024-02-02"));

        // New customer profile (null indicates a new record is not mandatory)
        CustomerProfile newCustomer = new CustomerProfile(
                -1, UUID.randomUUID(), "Bhuwan", "7 Jalpa", 2005, "2024-012-03"
        );

        // Update profiles
        List<CustomerProfile> updatedProfiles = updateProfile(existingProfiles, newCustomer);

        // Print updated profiles
        for (CustomerProfile profile : updatedProfiles) {
            System.out.println(profile);
        }
    }


}