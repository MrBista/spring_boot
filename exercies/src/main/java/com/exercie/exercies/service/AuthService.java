package com.exercie.exercies.service;

import com.exercie.exercies.dao.UserDaoImpl;
import com.exercie.exercies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private final UserDaoImpl userDaoImpl;

    @Autowired
    public AuthService(@Qualifier("userDaoImpl") UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public List<User> getAllUser(){
        return userDaoImpl.getAllUser();
    }


}
