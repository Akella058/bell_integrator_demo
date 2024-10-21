package com.example.demo.service.impl;

import com.example.demo.dto.AccountRqDto;
import com.example.demo.dto.FundsRqDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Card;
import com.example.demo.entity.User;
import com.example.demo.exception.CreditAccountExistException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AccountService;
import org.apache.catalina.connector.Response;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CardRepository cardRepository;

    public User getAuthUser(){
        Authentication authUser = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authUser.getName();
        return userRepository.findByEmail(userEmail).orElseThrow(()-> new UsernameNotFoundException("Пользователь не найден"));
    }

    public void createAccount(AccountRqDto accountRqDto) throws RuntimeException{
        User user = getAuthUser();
        if (accountRqDto.getType().toString().equals("CREDIT")){
            List<Account> accounts = accountRepository.findAllByType(accountRqDto.getType());
            accounts.forEach(account -> {
                if (account.getUser().equals(user)){
                    throw new CreditAccountExistException("У пользователя есть кредитный счет");
                }
            });
        }
        Random random = new Random();
        Account account = Account.builder()
                .type(accountRqDto.getType())
                .accountNumber(random.nextLong(999999999))
                .balance(0L)
                .user(user)
                .build();
        accountRepository.save(account);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> getAllByUser(){
        return accountRepository.findAllByUser(getAuthUser());
    }

    public void depositFunds(FundsRqDto fundsRqDto) throws BadRequestException{
        Card cardFromDB = cardRepository.findByCardNumber(Long.parseLong(fundsRqDto.getCardNumber()
                .replaceAll("\u00a0","")));
        Account accountFromDb = accountRepository.findByAccountNumber(cardFromDB.getAccount().getAccountNumber());
        if (fundsRqDto.getAction().equals(FundsRqDto.Action.IN)){
            accountFromDb.setBalance(accountFromDb.getBalance() + Long.parseLong(fundsRqDto.getFunds()));
        } else {
            if (accountFromDb.getBalance() < Long.parseLong(fundsRqDto.getFunds())){
                throw new BadRequestException("Сумма снятия больше остатка на счете");
            }
            accountFromDb.setBalance(accountFromDb.getBalance() - Long.parseLong(fundsRqDto.getFunds()));
        }
        accountRepository.save(accountFromDb);
    }
}
