package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserDto {
    private long userId;
    @NonNull
    private String username;
    private boolean isBlocked;
    private int userKey;
    private LocalDateTime keyValidDate;
}
