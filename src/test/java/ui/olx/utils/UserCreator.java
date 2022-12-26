package ui.olx.utils;

import ui.olx.entity.User;

public class UserCreator {
    public static final String USER_NAME = "6001mx7@gmail.com";
    public static final String USER_PASSWORD = "Titby12345678";

    public static User createDefaultUser() {
        return new User(USER_NAME, USER_PASSWORD);
    }

    public static User createUser(String name, String password) {
        return new User(name, password);
    }
}