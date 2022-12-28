package com.ahirajustice.drones.common.exceptions;

public class FailedDependencyException extends ApplicationDomainException {

    public FailedDependencyException(String message) {
        super(message, "FailedDependency", 424);
    }

}
