package com.pramati.lnr.mvc.controller;

import com.pramati.lnr.mvc.model.User;
import com.pramati.lnr.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: narendral
 * Date: 2/6/14
 * Time: 11:07 AM
 */

@Controller
@RequestMapping(value = "/users")
public class UserController {
    public static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User addUserByAttribute(@ModelAttribute User user) {
        logger.info("Inside Add by Attribute");

        userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "/addBody", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addUserByBody(@RequestBody User user) {
        logger.info("Inside Add by RequestBody");
        userService.addUser(user);
        return "User Added Successfully";
    }


    @RequestMapping(value = {"", "/", "/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> listUsers() {
        logger.info("Inside retrive users");
        return userService.listUser();

    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteUser(@PathVariable("userId") Integer userId) {

        logger.info("Inside delete users");

        try {
            userService.removeUser(userId);
        }catch (Exception e){
            e.printStackTrace();
            logger.info(e.toString());
            return "User Deleted Failed....Please check with admin";
        }

        return "User Deleted Successfully";
    }

    @RequestMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getUser(@PathVariable("userId") Integer userId) {
        logger.info("Inside get user::" + userId);
        logger.error("Error while retrieving selected user details", new java.lang.NullPointerException());



        return userService.selectUser(userId);
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        logger.info("Inside update user::" + userId);

        user.setId(userId);
        return userService.updateUser(user);
    }
}
