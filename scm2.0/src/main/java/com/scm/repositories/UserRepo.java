package com.scm.repositories;

import com.scm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    //extra methods for db related
    //custom query methods
    //custom finder methods

    Optional<User> findByEmail(String email);
}
