package com.example.bevss.controller;

import com.example.bevss.dto.AuthDTO;
import com.example.bevss.dto.CustomUserDetails;
import com.example.bevss.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestBody UserEntity user){
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        CustomUserDetails userDetails = (CustomUserDetails) authenticate.getPrincipal();
        String token = Jwts.builder()
                .setSubject(userDetails.getUser().toString())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS512, "SECRET")
                .compact();
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .body(new AuthDTO(token, userDetails.getUser()));
    }

}
