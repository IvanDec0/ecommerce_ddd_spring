package com.ecommerce_learning.ecommerce_learning.application.web.user.controller;

import com.ecommerce_learning.ecommerce_learning.application.web.user.request.LoginRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.user.request.UserRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.user.response.UserResponse;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.UserService;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest userRequest) {
        UserResponse user = userMapper.toUserResponse(userService.saveUser(userMapper.toUser(userRequest)));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest userRequest) {
        String token = userService.login(userMapper.toLoginUser(userRequest));
        return new ResponseEntity<>(token, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
