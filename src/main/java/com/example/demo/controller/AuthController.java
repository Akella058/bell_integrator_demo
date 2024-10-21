package com.example.demo.controller;

import com.example.demo.dto.UserRqDto;
import com.example.demo.dto.UserRsDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class AuthController {
    @Autowired
    private UserService userService;


//    @PostMapping("/registration")
//    public UserRsDto addUser(@RequestBody UserRqDto userRqDto){
//        return userService.addUser(userRqDto);
//    }
//
//    @GetMapping("/reg1")
//    public String test(){
//        return "test";
//    }
//
//    @GetMapping("/get_auth_user")
//    public String getAuthUser(){
//        return userService.getAuthUser();
//    }

    @GetMapping("/sign_in")
    public String getSignInPage() {
        return "sign_in";
    }

    @GetMapping("/sign_up")
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUpUser(UserRqDto userRqDto) {
//        String email = form.getEmail();
//        if(signUpService.isUserExist(email)) {
//            return "redirect:/signup";
//        }
        userService.addUser(userRqDto);
        return "redirect:/sign_in";
    }
}
