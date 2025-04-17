package com.example.service;

import com.example.model.Notification;
import com.example.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("smsNotificationService")
@Primary
public class SMSNotificationService implements NotificationService{

    private final NotificationRepository notificationRepository;

    @Autowired
    public SMSNotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendNotification(Notification notification) {

        System.out.println("Sending SMS notification to " + notification.getTo());
        System.out.println("Message: " +notification.getContent() );

        notificationRepository.save(notification);

    }

    @Override
    public String getServiceName() {
        return "SMS notification service";
    }
}
