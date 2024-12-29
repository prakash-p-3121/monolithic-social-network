package com.social.network.social_network.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@Builder
public class IDResponse {

    @JsonProperty("id")
    private BigInteger id;

}
