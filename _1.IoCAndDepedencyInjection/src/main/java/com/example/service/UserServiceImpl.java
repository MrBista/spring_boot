package com.example.service;

import com.example.model.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private final Map<String, String> userContacts = new HashMap<>();
    private final NotificationService defaultNotificatoinService;
    private final NotificationService emailNotificationService;
    private final NotificationService smsNotificationService;

    public UserServiceImpl(
            NotificationService defaultNotificatoinService,
            @Qualifier("emailNotificationService") NotificationService emailNotification,
            @Qualifier("smsNotificationService") NotificationService smsNotification) {
        this.defaultNotificatoinService = defaultNotificatoinService;
        this.emailNotificationService = emailNotification;
        this.smsNotificationService = smsNotification;

        System.out.println("Default service " + defaultNotificatoinService.getServiceName());
        System.out.println("Email service " + emailNotificationService.getServiceName());
        System.out.println("sms service " + smsNotificationService.getServiceName());
    }

    @Override
    public void registerUser(String username, String email, String phone) {
        System.out.println("Registering user " + username);

//        userContacts.put(username + ".username", username);
        userContacts.put(email+".email", email);
        userContacts.put(phone+".phone", phone);

        Notification notification = new Notification(email, "Welcome to our service", "Dear " + username + ", thank you for registering !");

        emailNotificationService.sendNotification(notification);

    }

    @Override
    public void notifyUser(String username, String subject, String content) {

        String email = userContacts.get(username+".email");
        String phone = userContacts.get(username+".phone");


        if (email != null){
            Notification emailNotification = new Notification(email, subject, content);
            emailNotificationService.sendNotification(emailNotification);
        }

        if (phone != null) {
            Notification smsNotification = new Notification(phone, subject, content);
            smsNotificationService.sendNotification(smsNotification);
        }



    }
}
