package com.rest.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {

    String firstName;
    String lastName;
    String patronymic;
}
