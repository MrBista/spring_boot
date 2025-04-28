package com.exercie.exercies.dao;

import com.exercie.exercies.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    @Override
    public List<User> getAllUser() {
        User user1 = new User();
        user1.setEmail("bisboy");
        user1.setId(1L);
        user1.setName("Boboby");
        user1.setPassword("hashpassword");
        user1.setEmail("bisboy@mail.com");
        return List.of(user1);
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
