package com.example.bevss.service;

import com.example.bevss.constaint.MessageCodeConstaint;
import com.example.bevss.dto.CustomUserDetails;
import com.example.bevss.entity.UserEntity;
import com.example.bevss.exception.CommonException;
import com.example.bevss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CommonException(HttpStatus.FORBIDDEN, MessageCodeConstaint.SE001);
        }
        return new CustomUserDetails(user);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity getDetail(Long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    public UserEntity save(UserEntity user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode("123456"));
        return userRepository.save(user);
    }

    public UserEntity delete(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }
}
