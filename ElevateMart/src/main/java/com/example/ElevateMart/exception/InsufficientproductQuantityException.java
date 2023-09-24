package com.example.ElevateMart.exception;

public class InsufficientproductQuantityException extends RuntimeException{
    public InsufficientproductQuantityException(String messange){
        super(messange);
    }
}
