package com.arnab.springSecurity.controller;

import com.arnab.springSecurity.model.Users;
import com.arnab.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userRegister")
    public Users register(@RequestBody Users users){
        return userService.registerUsers(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users) {
        return userService.verify(users);
    }
}
