package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    public enum Type{
        DEPOSIT, DEBIT, CREDIT
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private Type type;
    private Long balance;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @OneToMany(mappedBy = "account")
    private List<Card> cards;

}
