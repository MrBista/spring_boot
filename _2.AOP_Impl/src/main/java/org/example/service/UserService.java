package org.example.service;

import org.example.aspect.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void someMethod(){
        System.out.println("Ini dari " + this.getClass().getName() + " memanggil method someMethod");
    }

    @LogExecutionTime
    public String firstMethod(){
        try{
            int error = 1/0;
        } catch (Exception e) {
            System.out.println("ini apa errornya: " + e.getMessage());
        }

        return "This is value 3 in class firstMethod";
    }
}
