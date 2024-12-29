package com.social.network.social_network.controllers;

import com.social.network.social_network.exceptions.RestException;
import com.social.network.social_network.responses.IDResponse;
import com.social.network.social_network.responses.RestExceptionResponse;
import com.social.network.social_network.models.User;
import com.social.network.social_network.requests.UserCreateReq;
import com.social.network.social_network.requests.UserUpdateReq;
import com.social.network.social_network.services.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody @Validated @NonNull UserCreateReq userCreateReq,
                                        BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        BigInteger id = this.userService.createUser(userCreateReq);
        return ResponseEntity.ok(IDResponse.builder().id(id).build());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable BigInteger id) throws Exception {
        User user;
        try {
            user = this.userService.findUserById(id);
        } catch(RestException e) {
            return e.buildResponseEntity();
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(new RestExceptionResponse(e.getMessage()));
        }
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<?> patchUserById(@RequestBody @Validated @NonNull UserUpdateReq updateReq,
                                        @PathVariable BigInteger id,
                                        BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        int affectedRows;
        try {
            affectedRows = this.userService.patchUserById(id, updateReq);
        } catch(RestException e) {
            return e.buildResponseEntity();
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(
                    new RestExceptionResponse(
                            e.getMessage()
                    ));
        }
        return  ResponseEntity.ok(affectedRows);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable BigInteger id) throws Exception {

        int affectedRows;
        try {
             affectedRows = this.userService.deleteUserById(id);
        } catch(RestException e) {
            return e.buildResponseEntity();
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(
                    new RestExceptionResponse(
                            e.getMessage()
                    ));
        }
        return  ResponseEntity.ok(affectedRows);
    }

}
