package ru.tinkoff.fintech.qa.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tinkoff.fintech.qa.controllers.models.DefaultResponse;

@ControllerAdvice
public class RestExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {UsersDBException.class})
    protected ResponseEntity<DefaultResponse> handleDbEcxeption(
            UsersDBException ex) {
        String bodyOfResponse = ex.getMessage();
        return ResponseEntity.status(500).body(new DefaultResponse(bodyOfResponse));
    }
}