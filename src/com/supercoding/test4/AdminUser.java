package com.supercoding.test4;

public class AdminUser extends User {

    public AdminUser(String username, String role) {
        super(username, role);
    }

    @Override
    public String toString() {
        return "AdminUser{" + "username=" + getUsername() + ", role=" + getRole() + '}';
    }
}
