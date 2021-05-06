package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column
    private long orderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}