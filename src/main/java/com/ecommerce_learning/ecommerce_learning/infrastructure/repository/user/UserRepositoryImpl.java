package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.user;

import com.ecommerce_learning.ecommerce_learning.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

    private MongoUserRepository mongoUserRepository;

    public UserRepositoryImpl(MongoUserRepository mongoUserRepository) {
        this.mongoUserRepository = mongoUserRepository;
    }
}
