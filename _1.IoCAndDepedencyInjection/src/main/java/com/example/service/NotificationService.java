package com.example.service;

import com.example.model.Notification;

public interface NotificationService {
    void sendNotification(Notification notification);
    String getServiceName();

}
