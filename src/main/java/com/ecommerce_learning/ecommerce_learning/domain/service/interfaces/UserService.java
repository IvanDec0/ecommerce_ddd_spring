package com.ecommerce_learning.ecommerce_learning.domain.service.interfaces;

import com.ecommerce_learning.ecommerce_learning.domain.model.LoginUser;
import com.ecommerce_learning.ecommerce_learning.domain.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    void deleteUser(String id);

    User getUserById(String id);

    List<User> getAllUsers();

    String login(LoginUser user);
}
