package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FundsRqDto {
    public enum Action{
        IN, OUT
    }

    private String cardNumber;
    private String funds;
    private Action action;
}
