package com.InstitutionRegistry.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyFieldException extends RuntimeException{
    String path;

    public String getPath() {
        return path;
    }

    public EmptyFieldException(String message, String path) {
        super(message);
        this.path = path;
    }
}