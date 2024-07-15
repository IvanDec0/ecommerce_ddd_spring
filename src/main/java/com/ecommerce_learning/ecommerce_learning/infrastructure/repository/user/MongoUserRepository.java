package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.user;

import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.UserDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserRepository extends MongoRepository<UserDB, String> {

}