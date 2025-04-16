package com.example.service;

public interface UserService {
    void registerUser(String username, String email, String phone);
    void notifyUser(String username, String subject, String content);

}
