package com.mertdev.comune.Exceptions;

public class UnavailableEmailException extends RuntimeException{
    public UnavailableEmailException(String message) {
        super(message);
    }

    public UnavailableEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
