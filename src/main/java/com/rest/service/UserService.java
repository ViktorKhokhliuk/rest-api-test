package com.rest.service;

import com.rest.entity.User;
import com.rest.dto.UserDto;
import com.rest.exception.EntityNotFoundException;
import com.rest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + id + " not found"));

        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .patronymic(user.getPatronymic())
                .build();
    }

    public User save(UserDto userDto) {
        return userRepository.save(User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .patronymic(userDto.getPatronymic())
                .build());
    }

    @Transactional
    public User update(Long userId, UserDto dto) {
        User user = userRepository.findByIdForUpdate(userId)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + userId + " not found"));

        return userRepository.save(user.toBuilder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .patronymic(dto.getPatronymic())
                .build());
    }
}
