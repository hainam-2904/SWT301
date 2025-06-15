package com.hainam.security;

// Đưa constants vào class final
public final class Constants {
    public static final int MAX_USERS = 100;

    private Constants() {
        // Constructor private để tránh tạo instance
    }
}

public class InterfaceFieldModificationExample {
    public static void main(String[] args) {
        System.out.println("Max users: " + Constants.MAX_USERS);
    }
}
