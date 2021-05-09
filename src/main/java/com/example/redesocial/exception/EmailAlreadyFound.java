package com.example.redesocial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyFound extends ResponseStatusException {

    public EmailAlreadyFound(String emaill) {
        super(HttpStatus.BAD_REQUEST, String.format("Email %s already registered ", emaill));
    }
}
