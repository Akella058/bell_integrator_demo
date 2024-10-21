package com.example.demo.dto;

import com.example.demo.entity.Card;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRsDto {
    private Long cardNumber;
    private Card.CardType type;
    private Card.PaymentSystem paymentSystem;
    private Card.CardStatus cardStatus;
    private Long cardBalance;
}
