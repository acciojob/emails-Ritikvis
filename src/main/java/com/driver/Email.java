package com.driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        String regex = "^(?=.*[a-z])(?=."
                + "*[A-Z])(?=.*\\d)"
                + "(?=.*[-+_!@#$%^&*., ?]).+$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        if(oldPassword.equals(password) && !oldPassword.equals(null)) {
            if(newPassword.length() >= 8) {
                Matcher m = p.matcher(newPassword);
                if(m.matches()) {
                    this.password = newPassword;
                }
            }
        }
    }
}