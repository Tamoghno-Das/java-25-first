package com.example.exception;

public class DuplicateItemException extends Exception {
    public DuplicateItemException(String itemName) {
        super(itemName + " already exists");
    }
}
