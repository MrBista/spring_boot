package com.example.repository;

import com.example.model.Notification;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;


@Service
public class NotificationRepositoryImpl implements NotificationRepository{
    private Map<String, Notification> storage;

    @PostConstruct
    public void initialize(){
        storage = new HashMap<>();
    }

    @Override
    public void save(Notification notification) {
        System.out.println("Saving notifiaction " + notification.toString());
        storage.put(notification.getTo(), notification);
    }

    @Override
    public Notification findByRecipient(String recipient) {
        return storage.get(recipient);
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Cleaning up notification repository");
        storage.clear();
    }
}
