package com.rest.controller;

import com.rest.entity.User;
import com.rest.dto.UserDto;
import com.rest.service.UserService;
import com.rest.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;


    @GetMapping("/{id}")
    public UserDto findById(@PathVariable(name = "id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) {
        userValidator.validate(userDto);
        return userService.save(userDto);
    }

    @PutMapping("/{id}")
    private User updateUser(@PathVariable(name = "id") Long id, @RequestBody UserDto updatedUserDto) {
        userValidator.validate(updatedUserDto);
        return userService.update(id, updatedUserDto);
    }
}
