package com.wonokoyo.docin.login;

public class LoginUtil {
    public LoginUtil() {

    }

    public boolean loginValidate(String username, String password) {
        if (username.equalsIgnoreCase("dennis") && password.equalsIgnoreCase("dennis")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fieldUsernameValidate(String username) {
        if (!username.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fieldPasswordValidate(String password) {
        if (!password.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
