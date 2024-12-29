package com.social.network.social_network.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserUpdateReq {

    @Email(message = "Not a valid email id")
    @JsonProperty("email-id")
    private final String emailId;


    @NotBlank(message = "first name should not be blank")
    @JsonProperty("first-name")
    private final String firstName;


    @NotBlank(message = "last name should not be blank")
    @JsonProperty("last-name")
    private final String lastName;


    @NotBlank(message = "password should not be blank")
    @JsonProperty("password")
    private final String password;
}
