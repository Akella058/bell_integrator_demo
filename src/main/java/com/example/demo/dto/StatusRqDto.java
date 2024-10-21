package com.example.demo.dto;

import com.example.demo.entity.Card;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusRqDto {
    private String cardNumber;
    private Card.CardStatus status;
}
