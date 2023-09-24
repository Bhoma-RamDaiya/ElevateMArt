package com.example.ElevateMart.exception;

public class InvalidCardException extends RuntimeException{
    public InvalidCardException(String message){
        super(message);
    }
}
