package com.apple.thinking.annotations;

import java.util.List;

public class PasswordUtils {

    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("\\W*\\d\\w"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password)
                .reverse().toString();
    }

    @UseCase(id = 49, description = "New passwords can't equal previously userd ones")
    public boolean checkeForNewPassword(List<String> prevPasswords,String password) {
        return !prevPasswords.contains(password);
    }

}
