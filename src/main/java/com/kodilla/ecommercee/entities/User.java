package com.kodilla.ecommercee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "userId", nullable = false)
    private long userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "isBlocked")
    private boolean isBlocked;

    @Column(name = "userKey")
    private int userKey;

    @Column(name = "keyValidDate")
    private LocalDateTime keyValidDate;

    @OneToMany (
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders;

    public void addOrder (Order order) {
        orders.add(order);
    }
}