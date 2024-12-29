package com.social.network.social_network.repositories;

import com.social.network.social_network.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
public interface UserRepository extends CrudRepository<User, BigInteger> {

    @Modifying
    @Transactional
    @NativeQuery("""
           UPDATE users u 
           SET 
           u.first_name = COALESCE(:first_name, u.first_name), 
           u.email_id = COALESCE(:email_id, u.email_id), 
           u.last_name = COALESCE(:last_name, u.last_name) 
           WHERE u.id = :id 
          """)
    int patchUser(@Param("id") BigInteger id,
                    @Param("first_name") String firstName,
                    @Param("last_name") String lastName,
                    @Param("email_id") String emailId) throws Exception;

    @Modifying
    @Transactional
    @NativeQuery("DELETE FROM users u WHERE u.id = :id ")
    int deleteUserById(@Param("id") BigInteger id) throws Exception;
}
