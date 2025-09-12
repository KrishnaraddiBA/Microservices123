package com.authenticationService.service;

import com.authenticationService.dto.APIResponse;
import com.authenticationService.dto.UserDto;
import com.authenticationService.entity.User;
import com.authenticationService.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public APIResponse<String> register(UserDto dto) {

        if (userRepository.existsByUsername(dto.getUsername())){
            APIResponse<String> response=new APIResponse<>();
            response.setMessage("Registration failed");
            response.setStatus(500);
            response.setData("user with username already exists");
        }
        if (userRepository.existsByEmail(dto.getEmail())){
            APIResponse<String> response=new APIResponse<>();
            response.setMessage("Registration failed");
            response.setStatus(500);
            response.setData("user with email already exusts in our database");
        }
        User user=new User();
        BeanUtils.copyProperties(dto,user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        APIResponse<String> response=new APIResponse<>();
        response.setMessage("Registration done");
        response.setStatus(201);
        response.setData("User is registered");
        return response;
    }

    }
