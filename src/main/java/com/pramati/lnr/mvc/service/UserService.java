package com.pramati.lnr.mvc.service;

import com.pramati.lnr.mvc.model.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public List<User> listUser();

    public void removeUser(Integer id);

    public User selectUser(Integer userId);

    public User updateUser(User user);
}
