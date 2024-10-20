package com.selfpractise.webwallet.exceptions;

public class NotEnoughBalance extends RuntimeException{
    public NotEnoughBalance(String message) {
        super(message);
    }
}
