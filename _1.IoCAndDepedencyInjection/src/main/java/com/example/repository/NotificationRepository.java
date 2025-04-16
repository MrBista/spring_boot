package com.example.repository;

import com.example.model.Notification;

public interface NotificationRepository {
    void save(Notification notification);
    Notification findByRecipient(String recipient);
}
