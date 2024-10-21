package com.example.demo.controller;

import com.example.demo.dto.CardRqDto;
import com.example.demo.dto.StatusRqDto;
import com.example.demo.service.CardService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/cards")
    public String createCard(CardRqDto cardRqDto) {
        cardService.createCard(cardRqDto);
        return "redirect:/users/lk";
    }

    @PostMapping("/cards/change_status")
    public String changeStatus(StatusRqDto statusRqDto) throws BadRequestException {
        cardService.changeStatus(statusRqDto);
        return "redirect:/users/lk";
    }
}
