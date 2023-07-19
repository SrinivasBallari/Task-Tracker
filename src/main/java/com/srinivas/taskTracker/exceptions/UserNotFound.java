package com.srinivas.taskTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{
    String errorMessage;
    public UserNotFound(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
