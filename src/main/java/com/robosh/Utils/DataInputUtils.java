package com.robosh.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataInputUtils {

    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final String CORRECT_PASSWORD = "[a-zA-Z0-9]{8,20}";
    private static final String CORRECT_NAME = "([a-zA-Z]{0,10})";
    private static final String CORRECT_PHONE_NUMBER = "^(\\+380)([0-9]{9})";

    private DataInputUtils(){}

    public static boolean isNotCorrectEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return !matcher.matches();
    }

    /**
     * without <></>
     */
    public static boolean isNotValidPassword(String password1, String password2 ) {
        Pattern validPassword = Pattern.compile(CORRECT_PASSWORD);
        Matcher matcher = validPassword.matcher(password1);
        return isNotSamePassword(password1, password2) && !matcher.matches();
    }
    private static boolean isNotSamePassword(String password1, String password2) {
        return !password1.equals(password2);
    }

    private static boolean isNotCorrectName(String name) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(CORRECT_NAME);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(name);
        return !matcher.matches();
    }

    private static boolean isNotCorrectSurname(String surname){
        return isNotCorrectName(surname);
    }


    public static boolean isNotCorrectPhoneNumber(String phoneNumber) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(CORRECT_PHONE_NUMBER);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(phoneNumber);
        return !matcher.matches();
    }

    public static boolean isNotCorrectNameSurname(String name, String surname) {
        return isNotCorrectName(name) && isNotCorrectSurname(surname);
    }
}
