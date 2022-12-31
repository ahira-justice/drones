package com.ahirajustice.drones.common.exceptions;

public class ExpectationFailedException extends ApplicationDomainException {

    public ExpectationFailedException(String message) {
        super(message, "ExpectationFailed", 417);
    }

}
