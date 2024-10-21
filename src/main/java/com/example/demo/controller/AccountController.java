package com.example.demo.controller;

import com.example.demo.dto.AccountRqDto;
import com.example.demo.dto.FundsRqDto;
import com.example.demo.service.AccountService;
import com.example.demo.service.CardService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CardService cardService;

    @PostMapping("/accounts/create")
    public String createAccount(AccountRqDto accountRqDto) throws RuntimeException{
        accountService.createAccount(accountRqDto);
        return "redirect:/users/lk";
    }

    @GetMapping("/users/lk")
    public String userLk(Model model){
        model.addAttribute("accounts", accountService.getAllByUser());
        model.addAttribute("cards", cardService.getAllCardsByUser());
        return "user_main_page";
    }

    @PostMapping("/accounts/deposit_funds")
    public String deposit_funds(FundsRqDto fundsRqDto) throws BadRequestException {
        accountService.depositFunds(fundsRqDto);
        return "redirect:/users/lk";
    }
}
