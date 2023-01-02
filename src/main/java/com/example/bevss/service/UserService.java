package com.example.bevss.service;

import com.example.bevss.constaint.MessageCodeConstaint;
import com.example.bevss.dto.CustomUserDetails;
import com.example.bevss.entity.UserEntity;
import com.example.bevss.exception.CommonException;
import com.example.bevss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CommonException(MessageCodeConstaint.SE001);
        }
        return new CustomUserDetails(user);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
