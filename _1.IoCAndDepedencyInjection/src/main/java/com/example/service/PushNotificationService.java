package com.example.service;

import com.example.model.Notification;
import com.example.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class PushNotificationService implements NotificationService{
    private NotificationRepository notificationRepository;

    // Contoh setter injection
    @Autowired
    public void setNotificationRepository(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Initializing Push Notification Service");
    }

    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Sending PUSH notification to: " + notification.getTo());
        System.out.println("Alert: " + notification.getSubject());
        System.out.println("Details: " + notification.getContent());

        // Simpan notifikasi ke repository
        notificationRepository.save(notification);
    }

    @Override
    public String getServiceName() {
        return "Push Notification Service";
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Cleaning up Push Notification Service");
    }
}
