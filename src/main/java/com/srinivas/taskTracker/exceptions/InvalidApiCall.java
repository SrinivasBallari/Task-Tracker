package com.srinivas.taskTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidApiCall extends RuntimeException{
    String errorMessage;

    public InvalidApiCall(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
