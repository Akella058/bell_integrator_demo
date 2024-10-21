package com.example.demo.service;

import com.example.demo.dto.UserRqDto;
import com.example.demo.dto.UserRsDto;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    void addUser(UserRqDto userRqDto);

    String getAuthUser();
    List<User> getAllUsers();
}
