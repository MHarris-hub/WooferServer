package com.app.woofer.aop;

import com.app.woofer.exceptions.WooferException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(WooferException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public WooferException handleWooferException(WooferException e) {
        return e;
    }
}
