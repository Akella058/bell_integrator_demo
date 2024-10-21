package com.example.demo.exception;

public class CreditAccountExistException extends RuntimeException{
    public CreditAccountExistException(String message){ super(message);}
}
