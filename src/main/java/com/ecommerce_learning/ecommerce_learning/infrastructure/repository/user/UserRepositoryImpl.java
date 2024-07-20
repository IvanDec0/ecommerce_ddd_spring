package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.user;

import com.ecommerce_learning.ecommerce_learning.domain.model.User;
import com.ecommerce_learning.ecommerce_learning.domain.repository.UserRepository;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.UserDB;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final MongoUserRepository mongoUserRepository;
    private final UserMapper mapper;

    public UserRepositoryImpl(MongoUserRepository mongoUserRepository, UserMapper mapper) {
        this.mongoUserRepository = mongoUserRepository;
        this.mapper = mapper;
    }


    @Override
    public User save(User user) {
        UserDB userDB = mapper.toMongoUser(user);
        UserDB savedUserDB = mongoUserRepository.save(userDB);
        return mapper.toUser(savedUserDB);
    }

    @Override
    public void deleteById(String id) {
        mongoUserRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(String id) {
        return mongoUserRepository.findById(id).map(mapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return mongoUserRepository.findAll().stream()
                .map(mapper::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsByEmail(String email) {
        return mongoUserRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsById(String id) {
        return mongoUserRepository.existsById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return mongoUserRepository.findByEmail(email).map(mapper::toUser);
    }
}
