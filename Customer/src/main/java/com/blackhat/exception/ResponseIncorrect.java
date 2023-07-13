package com.blackhat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ResponseIncorrect extends RuntimeException{

    public ResponseIncorrect(String message){
        super(message);
    }
}
