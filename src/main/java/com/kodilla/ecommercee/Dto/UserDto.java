package com.kodilla.ecommercee.Dto;

import com.kodilla.ecommercee.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDto {
    private long userId;
    @NonNull
    private String username;
    private boolean isBlocked;
    private int userKey;
    private LocalDateTime keyValidDate;
    private List<Order> orders;
}
