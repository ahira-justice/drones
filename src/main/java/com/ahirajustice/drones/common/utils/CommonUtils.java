package com.ahirajustice.drones.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtils {

    public static boolean containsSpecialCharactersAndNumbers(String str) {
        String specialCharactersAndNumbers = "!@#$%&*()'+,-./:;<=>?[]^`{|}0123456789";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (specialCharactersAndNumbers.contains(Character.toString(ch))) {
                return true;
            }
        }

        return false;
    }

    public static String generateRandomString(int length) {
        return generateRandomString(length, "0123456789");
    }

    public static String generateRandomString(int length, String alphabet) {
        Random random = new SecureRandom();
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        return new String(returnValue);
    }

}
