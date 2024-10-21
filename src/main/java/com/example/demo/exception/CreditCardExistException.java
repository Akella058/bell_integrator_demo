package com.example.demo.exception;

public class CreditCardExistException extends RuntimeException{
    public CreditCardExistException(String message){ super(message);}
}
