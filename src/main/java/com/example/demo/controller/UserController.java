package com.example.demo.controller;

import com.example.demo.dto.AccountRqDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<User> users= userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
//    @PostMapping("/users/lk")
//    public String userLk(AccountRqDto accountRqDto){
//        return "user_main_page";
//    }
}
