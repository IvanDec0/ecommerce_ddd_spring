package com.ecommerce_learning.ecommerce_learning.domain.repository;

import com.ecommerce_learning.ecommerce_learning.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    void deleteById(String id);

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    Boolean existsByEmail(String email);

    Boolean existsById(String id);
}
