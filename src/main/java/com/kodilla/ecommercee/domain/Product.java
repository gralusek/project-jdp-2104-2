package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long productId;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts;

    public Product(){
        carts = new ArrayList<>();
    }

}
