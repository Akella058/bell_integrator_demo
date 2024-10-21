package com.example.demo.service.impl;

import com.example.demo.dto.UserRqDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public void addUser(UserRqDto userRqDto){
        User user = User.builder()
                .role(User.Role.USER)
                .email(userRqDto.getEmail())
                .password(passwordEncoder.encode(userRqDto.getPassword()))
                .firstName(userRqDto.getFirstName())
                .lastName(userRqDto.getLastName())
                .passport(userRqDto.getPassport())
                .birthDate(userRqDto.getBirthDate())
                .build();
        userRepository.save(user);
    }

    public String getAuthUser(){
        Authentication authUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = authUser.getName();
        return userName;
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
