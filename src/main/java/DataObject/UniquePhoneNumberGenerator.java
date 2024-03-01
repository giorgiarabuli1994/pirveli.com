package DataObject;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniquePhoneNumberGenerator {

    private static final Set<String> usedNumbers = new HashSet<>();
    private static final Set<String> allGeneratedNumbers = new HashSet<>();
    private static final Random random = new Random();
    private static final String PREFIX = "539";
    private static final String ID = "99";
    private static String lastGeneratedNumber = null; // Variable to hold the last generated number

    public static String generateUniquePhoneNumber() {
        String phoneNumber;
        do {
            // Generate a 6-digit number and prepend with the prefix
            phoneNumber = PREFIX + String.format("%06d", random.nextInt(1000000));
        } while (usedNumbers.contains(phoneNumber));

        usedNumbers.add(phoneNumber);
        allGeneratedNumbers.add(phoneNumber);
        lastGeneratedNumber = phoneNumber; // Update the last generated number
        return phoneNumber;
    }

    // Method to get the last generated number
    public static String getLastGeneratedNumber() {
        return lastGeneratedNumber;
    }

    public static String generateUniqueIdNumber() {
        String idNumber;
        do {
            // Generate a 6-digit number and prepend with the prefix
            idNumber = ID + String.format("%09d", random.nextInt(1000000));
        } while (usedNumbers.contains(idNumber));

        usedNumbers.add(idNumber);
        return idNumber;
    }
}
