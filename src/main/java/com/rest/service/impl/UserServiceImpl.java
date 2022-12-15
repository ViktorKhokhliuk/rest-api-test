package com.rest.service.impl;

import com.rest.entity.User;
import com.rest.dto.UserDto;
import com.rest.exception.EntityNotFoundException;
import com.rest.mapper.ToUserDtoMapper;
import com.rest.mapper.ToUserMapper;
import com.rest.repository.UserRepository;
import com.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ToUserMapper userMapper;
    private final ToUserDtoMapper userDtoMapper;


    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + id + " not found"));
        return userDtoMapper.map(user);
    }

    @Override
    public User save(UserDto userDto) {
        User newUser = userMapper.map(userDto);
        return userRepository.save(newUser);
    }

    @Override
    @Transactional
    public User update(Long userId, UserDto updatedUserDto) {
        User updatedUser = userRepository.findByIdForUpdate(userId)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + userId + " not found"));
        updatedUser.setFirstName(updatedUserDto.getFirstName());
        updatedUser.setLastName(updatedUserDto.getLastName());
        updatedUser.setPatronymic(updatedUserDto.getPatronymic());
        return userRepository.save(updatedUser);
    }
}
