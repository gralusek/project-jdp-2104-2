package com.kodilla.ecommercee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class userDto {
    private long userId;
    @NonNull
    private String username;
    private boolean status;
    private int userKey;
    private LocalDateTime keyValidDate;
}
