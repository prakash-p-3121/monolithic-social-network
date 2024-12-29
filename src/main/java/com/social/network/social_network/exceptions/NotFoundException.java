package com.social.network.social_network.exceptions;

import com.social.network.social_network.responses.RestExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotFoundException extends RestException {

    public NotFoundException(String message) {
        super(message);
    }

    public ResponseEntity<?> buildResponseEntity() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestExceptionResponse(this.getMessage()));
    }
}
