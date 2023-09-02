package com.example.gitrepoproject.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public HttpStatusCode getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}

