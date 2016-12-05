package com.agr.puhup.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}