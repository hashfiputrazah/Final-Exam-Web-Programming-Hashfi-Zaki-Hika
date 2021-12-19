package com.springboot_tiles.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
