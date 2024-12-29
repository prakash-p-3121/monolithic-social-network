package com.social.network.social_network.exceptions;

import org.springframework.http.ResponseEntity;

public abstract class RestException extends Exception {
    private String message;

    public RestException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public abstract ResponseEntity<?> buildResponseEntity();
}
