package com.social.network.social_network.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestExceptionResponse {

    @JsonProperty("reason")
    private String reason;
    public RestExceptionResponse(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }
}
