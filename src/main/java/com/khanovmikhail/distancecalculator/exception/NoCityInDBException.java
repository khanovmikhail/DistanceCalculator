package com.khanovmikhail.distancecalculator.exception;

public class NoCityInDBException extends RuntimeException {
    public NoCityInDBException(String message) {
        super(message);
    }
}
