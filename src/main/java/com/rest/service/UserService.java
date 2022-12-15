package com.rest.service;

import com.rest.entity.User;
import com.rest.dto.UserDto;

public interface UserService {
    UserDto findById(Long id);

    User save(UserDto userDto);

    User update(Long userId, UserDto updatedUserDto);
}
