package com.social.network.social_network.services;

import com.social.network.social_network.models.User;
import com.social.network.social_network.requests.UserCreateReq;
import com.social.network.social_network.requests.UserUpdateReq;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface UserService {

    BigInteger createUser(UserCreateReq req) throws Exception;
    User findUserById(BigInteger id) throws Exception;
    int patchUserById(BigInteger id, UserUpdateReq req) throws Exception;
    int deleteUserById(BigInteger id) throws Exception;
}
