package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cards")
public class Card {
    public enum CardType{
        DEBIT,
        CREDIT
    }

    public enum PaymentSystem{
        MIR,
        VISA,
        MASTERCARD
    }

    public enum CardStatus{
        ACTIVE,
        BLOCKED,
        CLOSED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardNumber;
    private CardType type;
    private PaymentSystem paymentSystem;
    private CardStatus cardStatus;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "accounts_id")
    private Account account;
}
