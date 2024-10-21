package com.example.demo.dto;

import com.example.demo.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRqDto {
    private Account.Type type;
}
