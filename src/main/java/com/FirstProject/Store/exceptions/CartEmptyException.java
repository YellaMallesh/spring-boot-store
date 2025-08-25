package com.FirstProject.Store.exceptions;

public class CartEmptyException extends RuntimeException {
        public  CartEmptyException() {
            super("Cart is empty");
        }
}
