package com.example.bevss.controller;

import com.example.bevss.entity.UserEntity;
import com.example.bevss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getDetail(@PathVariable Long id) {
        return userService.getDetail(id);
    }

    @PostMapping()
    public UserEntity save(@RequestBody UserEntity user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public UserEntity delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
