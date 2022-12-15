package com.rest.mapper;

import com.rest.entity.User;
import com.rest.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class ToUserDtoMapper {

    public UserDto map(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPatronymic(user.getPatronymic());
        return userDto;
    }
}
