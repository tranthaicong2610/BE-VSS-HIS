package com.example.bevss.controller;

import com.example.bevss.entity.UserEntity;
import com.example.bevss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public List<UserEntity> getAll() {
        return userService.getAll();
    }
}
