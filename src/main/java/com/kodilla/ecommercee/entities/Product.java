package com.kodilla.ecommercee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "Products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "productId")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;
}
