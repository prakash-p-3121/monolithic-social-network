package com.social.network.social_network.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import  jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Data
@Getter
public class UserCreateReq {

    @Email(message = "Not a valid email id")
    @JsonProperty("email-id")
    @NotNull(message = "email id should not be null")
    private final String emailId;

    @NotNull(message = "first name should not be null")
    @NotBlank(message = "first name should not be blank")
    @JsonProperty("first-name")
    private final String firstName;

    @NotNull(message = "last name should not be null")
    @NotBlank(message = "last name should not be blank")
    @JsonProperty("last-name")
    private final String lastName;

    @NotNull(message  = "password should not be null")
    @NotBlank(message = "password should not be blank")
    @JsonProperty("password")
    private final String password;

}
