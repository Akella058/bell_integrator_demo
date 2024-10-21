package com.example.demo.repository;

import com.example.demo.entity.Card;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByType(Card.CardType type);
    Card findByCardNumber(Long cardNumber);
    List<Card> findAllByUser(User user);
}
