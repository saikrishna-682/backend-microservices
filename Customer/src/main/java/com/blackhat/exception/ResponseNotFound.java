package com.blackhat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResponseNotFound extends RuntimeException{

    public ResponseNotFound(String message){
        super(message);
    }
}
