package com.example.demo.dto;

import com.example.demo.entity.Account;
import com.example.demo.entity.Card;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRqDto {
    private String account;
    private Card.CardType cardType;
    private Card.PaymentSystem paymentSystem;
}
