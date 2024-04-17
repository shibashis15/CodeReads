package com.cartservice.com.util;

public class ProductDoesNotExists extends RuntimeException{
    public ProductDoesNotExists(String message) {
        super(message);
    }
}
