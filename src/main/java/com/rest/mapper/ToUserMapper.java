package com.rest.mapper;

import com.rest.entity.User;
import com.rest.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class ToUserMapper {
    public User map(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .patronymic(userDto.getPatronymic())
                .build();
    }
}
