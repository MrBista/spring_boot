package com.example.service;

import com.example.model.Notification;
import com.example.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("emailNotificationService")
public class EmailNotificationService implements NotificationService{
    private final NotificationRepository notificationRepository;

    @Autowired
    public EmailNotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Sending Email notification to: " + notification.getTo());
        System.out.println("Subject: " + notification.getSubject());
        System.out.println("Content: " + notification.getContent());

        notificationRepository.save(notification);

    }

    @Override
    public String getServiceName() {
        return "Email Notification Service";
    }
}
