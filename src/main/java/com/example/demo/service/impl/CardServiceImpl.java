package com.example.demo.service.impl;

import com.example.demo.dto.CardRqDto;
import com.example.demo.dto.CardRsDto;
import com.example.demo.dto.StatusRqDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Card;
import com.example.demo.entity.User;
import com.example.demo.exception.CreditCardExistException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CardService;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;

    public User getAuthUser(){
        Authentication authUser = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authUser.getName();
        return userRepository.findByEmail(userEmail).orElseThrow(()-> new UsernameNotFoundException("Пользователь не найден"));
    }

    public void createCard(CardRqDto cardRqDto){
        User user = getAuthUser();
        String account = cardRqDto.getAccount().replaceAll("\u00a0","");
        Account accountFromDB = accountRepository.findByAccountNumber(Long.parseLong(account));
        if (cardRqDto.getCardType().equals(Card.CardType.CREDIT)){
            if (!accountFromDB.getCards().isEmpty()){
                throw new CreditCardExistException("На данном счете уже есть кредитная карта");
            }
        }
        Random random = new Random();
        Card card = Card.builder()
                .type(cardRqDto.getCardType())
                .cardNumber(random.nextLong(999999999))
                .account(accountFromDB)
                .paymentSystem(cardRqDto.getPaymentSystem())
                .user(getAuthUser())
                .cardStatus(Card.CardStatus.CLOSED)
                .build();
        cardRepository.save(card);
    }

    public List<CardRsDto> getAllCardsByUser(){
        List<Card> cards = cardRepository.findAllByUser(getAuthUser());
        List<CardRsDto> cardRsDtoList = new ArrayList<>();
        cards.forEach(card -> {
            CardRsDto cardRsDto = modelMapper.map(card, CardRsDto.class);
            cardRsDto.setCardBalance(card.getAccount().getBalance());
            cardRsDtoList.add(cardRsDto);
        });
        return cardRsDtoList;
    }



    public void changeStatus(StatusRqDto statusRqDto) throws BadRequestException{
        Card cardFromDB = cardRepository.findByCardNumber(Long.parseLong(statusRqDto.getCardNumber()
                .replaceAll("\u00a0","")));
        if (cardFromDB.getCardStatus().equals(Card.CardStatus.CLOSED)){
            throw new BadRequestException("Карта закрыта");
        }
        if (!cardFromDB.getCardStatus().equals(statusRqDto.getStatus())){
            cardFromDB.setCardStatus(statusRqDto.getStatus());
        }
        cardRepository.save(cardFromDB);
    }

}
