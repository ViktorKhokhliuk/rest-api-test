package com.rest.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDto {

    private final Integer code;
    private final String message;
    private final LocalDateTime timeStamp;
}
