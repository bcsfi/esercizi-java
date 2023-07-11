package net.bcsoft.bcvinaino.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IdNotFoundException.class })
    protected ResponseEntity<Object> idNotFound (RuntimeException exception, WebRequest request) {
        String bodyOfResponse = exception.getMessage();
        return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(),
                                        HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { IdNotValidException.class, DateNotValidException.class })
    protected ResponseEntity<Object> idNotValid (RuntimeException exception, WebRequest request) {
        String bodyOfResponse = exception.getMessage();
        return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(),
                                        HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

}
