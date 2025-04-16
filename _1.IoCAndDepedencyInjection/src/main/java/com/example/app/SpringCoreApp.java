package com.example.app;

import com.example.config.AppConfig;
import com.example.service.PushNotificationService;
import com.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try{
            UserService userService = context.getBean(UserService.class);

            userService.registerUser("john_doe", "john@example.com", "123456789");

            userService.notifyUser("john_doe", "New Feature Available",
                    "We've just launched a new feature you might be interested in!");

            // Mendapatkan service spesifik
            PushNotificationService pushNotificationService = context.getBean(PushNotificationService.class);
            System.out.println("Got service " + pushNotificationService.getServiceName());
        }finally {
            context.close();
        }
    }
}
