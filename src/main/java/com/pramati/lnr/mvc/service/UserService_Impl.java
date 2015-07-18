package com.pramati.lnr.mvc.service;

import com.pramati.lnr.mvc.dao.UserDAO;
import com.pramati.lnr.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService_Impl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public List<User> listUser() {
        return userDAO.listUser();
    }

    @Transactional
    public void removeUser(Integer id) {
        userDAO.removeUser(id);
    }

    @Transactional
    public User selectUser(Integer userId) {
        return userDAO.selectUser(userId);
    }

    @Transactional
    public User updateUser(User user) {
        return userDAO.updateUser(user);

    }
}
