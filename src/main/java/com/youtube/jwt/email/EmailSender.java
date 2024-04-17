package com.youtube.jwt.email;

public interface EmailSender {
    void send(String to, String email);
}