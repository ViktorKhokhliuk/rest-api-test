package com.rest.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ErrorResponseDto {

    Integer code;
    String message;
    LocalDateTime timeStamp;
}
