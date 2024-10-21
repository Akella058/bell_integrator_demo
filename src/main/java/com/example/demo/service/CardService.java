package com.example.demo.service;

import com.example.demo.dto.CardRqDto;
import com.example.demo.dto.CardRsDto;
import com.example.demo.dto.StatusRqDto;
import com.example.demo.entity.Card;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CardService {
    public void createCard(CardRqDto cardRqDto);
    public List<CardRsDto> getAllCardsByUser();
    public void changeStatus(StatusRqDto statusRqDto) throws BadRequestException;
}
