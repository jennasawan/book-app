package com.bookapp.dao;

import com.bookapp.model.RegisterUserDto;
import com.bookapp.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
