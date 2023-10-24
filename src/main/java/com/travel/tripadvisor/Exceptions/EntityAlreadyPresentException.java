package com.travel.tripadvisor.Exceptions;

public class EntityAlreadyPresentException extends RuntimeException {
    EntityAlreadyPresentException(String message) {
        super(message);
    }
}
