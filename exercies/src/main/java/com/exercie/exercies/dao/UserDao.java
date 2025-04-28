package com.exercie.exercies.dao;

import com.exercie.exercies.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();
    public User getUserById(Long id);
    public void saveUser(User user);
    public void deleteUser(User user);
}
