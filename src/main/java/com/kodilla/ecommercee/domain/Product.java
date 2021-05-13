package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@Entity(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupID")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
        name = "Join_Cart_Product",
        joinColumns = {@JoinColumn(name = "Product_Id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "Cart_Id", referencedColumnName = "id")}
    )
    private List<Cart> carts;

    public Product(){
        carts = new ArrayList<>();
    }
}