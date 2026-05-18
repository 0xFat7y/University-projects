package com.mycompany.crystalpalacehotel;

public class LogIn implements Customer {

    private final String Username, Password, email;
    private final int phoneNumber;

    public LogIn(String Username, String Password, String email, int phoneNumber) {
        this.Username = Username;
        this.Password = Password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String UserName() {
        return Username;
    }

    @Override
    public int phoneNumber() {
        return phoneNumber;
    }

    @Override
    public String Email() {
        return email;
    }

    @Override
    public String Password() {
        return Password;
    }

}