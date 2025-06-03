package com.praktikum.users;

public abstract class Users {
    protected String name, password;

    protected Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    protected abstract void displayAppMenu();
    protected abstract void logout();
    public abstract boolean login(String inputName, String inputPassword);
    protected abstract boolean prosesLogin(String inputName, String inputPassword);
}
