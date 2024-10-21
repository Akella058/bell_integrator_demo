package com.example.demo.service;

import com.example.demo.dto.AccountRqDto;
import com.example.demo.dto.FundsRqDto;
import com.example.demo.entity.Account;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface AccountService {
    public void createAccount(AccountRqDto accountRqDto) throws RuntimeException;
    public List<Account> getAllAccounts();
    public void depositFunds(FundsRqDto fundsRqDto) throws BadRequestException;
    public List<Account> getAllByUser();
}
