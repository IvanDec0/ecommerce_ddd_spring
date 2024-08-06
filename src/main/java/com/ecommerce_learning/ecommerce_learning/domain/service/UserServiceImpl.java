package com.ecommerce_learning.ecommerce_learning.domain.service;

import com.ecommerce_learning.ecommerce_learning.domain.model.LoginUser;
import com.ecommerce_learning.ecommerce_learning.domain.model.Roles;
import com.ecommerce_learning.ecommerce_learning.domain.model.User;
import com.ecommerce_learning.ecommerce_learning.domain.repository.UserRepository;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ecommerce_learning.ecommerce_learning.domain.model.Roles.ROLE_USER;
import static com.ecommerce_learning.ecommerce_learning.shared.util.ReturnConstants.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException(String.format(USER_EMAIL_EXISTS, user.getEmail()));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Set Roles (Enums)
        if (user.getTypo() == null) {
            user.setTypo(ROLE_USER.name());
        } else {
            if (!Roles.contains(user.getTypo())) {
                throw new IllegalArgumentException("Invalid role");
            }
            user.setTypo(Roles.valueOf(user.getTypo()).name()); // Convert typo to Enum (Test)
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException(String.format(USER_NOT_FOUND_BY_ID, id));
        }
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format(USER_NOT_FOUND_BY_ID, id)));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String login(LoginUser loginUser) {
        User user = userRepository.findByEmail(loginUser.getEmail()).orElseThrow(() -> new IllegalArgumentException(String.format(USER_NOT_FOUND_BY_EMAIL, loginUser.getEmail())));
        //if (!passwordEncoder.matches(password, user.getPassword())) {
        //    throw new IllegalArgumentException("Invalid password");
        //}
        return user.getName();
    }

}
