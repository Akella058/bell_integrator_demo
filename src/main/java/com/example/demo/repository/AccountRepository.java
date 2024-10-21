package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByType(Account.Type type);
    Account findByAccountNumber(Long account);
    List<Account> findAllByUser(User user);
}