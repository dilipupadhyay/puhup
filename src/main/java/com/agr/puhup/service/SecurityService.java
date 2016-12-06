package com.agr.puhup.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.agr.puhup.model.User;

public interface SecurityService {
    String findLoggedInUsername();

    UsernamePasswordAuthenticationToken autologin(String username, String password);

	UsernamePasswordAuthenticationToken login(User user);
}