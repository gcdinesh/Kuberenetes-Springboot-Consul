package com.shopper.product.exceptions;

final public class Messages {
    public static final String code1 = "00001.1";
    public static final String code2 = "00001.2";
    public static final String code3 = "00001.3";
    public static final String code4 = "00001.4";

    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String USER_NOT_FOUND = "User {0} not found";
    public static final String INVALID_EMAIL_ID = "Invalid Email Id";
    public static final String INVALID_PASSWORD = "Invalid Password";
    public static final String INVALID_PASSWORD_CREATION = "Please enter a valid password." +
            " The password should be minimum of length 8. Password must contain atleast one upperCase, one lowerCase," +
            " one digit and one special Character('.', '$', '/', '!', '@', '#', '^', '&', '*', '-', '_', ',')";
    public static final String USER_ALREADY_EXISTS = "User {0} already exists";
    public static final String INVALID_USER_NAME = "UserName should not be empty";
}
