package com.example.demo.service;

import com.example.demo.dto.UserRqDto;
import com.example.demo.dto.UserRsDto;

public interface AuthService {
    public UserRsDto addUser(UserRqDto userRqDto);
}
