package com.example.Cart_Shopping.Exception;

public class ItemNotFoundException extends  RuntimeException{
    public ItemNotFoundException(String message){
        super(message);
    }
}
