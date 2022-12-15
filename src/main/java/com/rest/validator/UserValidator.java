package com.rest.validator;

import com.rest.dto.UserDto;
import com.rest.entity.User;
import com.rest.exception.UniqueFullNameException;
import com.rest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final UserRepository userRepository;

    public void validate(UserDto dto) {
        Optional<User> user = userRepository.findByFullName(dto.getFirstName(), dto.getLastName(), dto.getPatronymic());
        if (user.isPresent()) {
            throw new UniqueFullNameException("user with these first name, last name and patronymic already exists");
        }
    }
}
