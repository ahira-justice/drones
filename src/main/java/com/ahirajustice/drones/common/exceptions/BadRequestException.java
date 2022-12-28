package com.ahirajustice.drones.common.exceptions;

public class BadRequestException extends ApplicationDomainException {

    public BadRequestException(String message) {
        super(message, "BadRequest", 400);
    }

}
