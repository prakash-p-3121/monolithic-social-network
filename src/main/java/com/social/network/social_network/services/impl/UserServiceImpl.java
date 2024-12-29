package com.social.network.social_network.services.impl;

import com.social.network.social_network.exceptions.NotFoundException;
import com.social.network.social_network.models.User;
import com.social.network.social_network.requests.UserCreateReq;
import com.social.network.social_network.repositories.UserRepository;
import com.social.network.social_network.requests.UserUpdateReq;
import com.social.network.social_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BigInteger createUser(UserCreateReq req) throws Exception {

        User user = User.builder()
                    .emailId(req.getEmailId())
                    .firstName(req.getFirstName())
                    .lastName(req.getLastName())
                    .hashedPassword(req.getPassword())
                    .build();

        this.userRepository.save(user);
        return user.getId();
    }

    @Override
    public User findUserById(BigInteger id) throws Exception {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NotFoundException("user-id");
    }

    @Override
    public int patchUserById(BigInteger id, UserUpdateReq req) throws Exception {
        return this.userRepository.patchUser(id,
                            req.getFirstName(),
                            req.getLastName(),
                            req.getEmailId()
                            );
    }

    @Override
    public int deleteUserById(BigInteger id) throws Exception {
         return this.userRepository.deleteUserById(id);
    }
}
