package com.pramati.lnr.mvc.dao;

import com.pramati.lnr.mvc.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: narendral
 * Date: 2/6/14
 * Time: 11:48 AM
 */
public interface UserDAO {

    public void addUser(User user);

    public List<User> listUser();

    public void removeUser(Integer id);

    public User selectUser(Integer userId);

    public User updateUser(User user);
}
