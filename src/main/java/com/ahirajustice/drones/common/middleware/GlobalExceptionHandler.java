package com.ahirajustice.drones.common.middleware;

import com.ahirajustice.drones.common.error.Error;
import com.ahirajustice.drones.common.error.ErrorResponse;
import com.ahirajustice.drones.common.exceptions.ApplicationDomainException;
import com.ahirajustice.drones.common.exceptions.ExpectationFailedException;
import com.ahirajustice.drones.common.exceptions.ForbiddenException;
import com.ahirajustice.drones.common.exceptions.NotFoundException;
import com.ahirajustice.drones.common.exceptions.SystemErrorException;
import com.ahirajustice.drones.common.exceptions.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);

        if (ex instanceof ApplicationDomainException) {
            return handleApplicationDomainException((ApplicationDomainException) ex);
        }
        else if (ex instanceof NoHandlerFoundException) {
            return handleNoHandlerFoundException((NoHandlerFoundException) ex);
        }
        else if (ex instanceof AccessDeniedException) {
            return handleAccessDeniedException();
        }
        else if (ex instanceof BindException) {
            return handleBindException((BindException) ex);
        }
        else if (ex instanceof MaxUploadSizeExceededException) {
            return handleMaxUploadSizeExceededException((MaxUploadSizeExceededException) ex);
        }
        else {
            return handleUnknownException();
        }
    }

    private ResponseEntity<ErrorResponse> handleApplicationDomainException(ApplicationDomainException ex) {
        return new ResponseEntity<>(ex.toErrorResponse(), HttpStatus.valueOf(ex.getStatusCode()));
    }

    private ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        String msg = String.format("Route %s %s does not exist", ex.getHttpMethod(), ex.getRequestURL());
        return handleApplicationDomainException(new NotFoundException(msg));
    }

    private ResponseEntity<ErrorResponse> handleAccessDeniedException() {
        return handleApplicationDomainException(new ForbiddenException());
    }

    private ResponseEntity<ErrorResponse> handleBindException(BindException ex) {
        List<Error> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> Error.create(error.getField(), error.getDefaultMessage(), error.getRejectedValue()))
                .collect(Collectors.toList());

        return handleApplicationDomainException(new ValidationException(errors));
    }

    private ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        String msg = String.format("Uploaded file too large. File upload limit is: %s", ex.getMaxUploadSize());
        return handleApplicationDomainException(new ExpectationFailedException(msg));
    }

    private ResponseEntity<ErrorResponse> handleUnknownException() {
        return handleApplicationDomainException(new SystemErrorException());
    }

}
