package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "Product_Id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "price")
    @NotNull
    private double price;

    @ManyToOne
    @JoinColumn(name = "groupID")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
        name = "Join_Cart_Product",
        joinColumns = {@JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")},
            inverseJoinColumns = {@JoinColumn(name = "Cart_Id", referencedColumnName = "Cart_Id")}
    )
    private List<Cart> productsInCart;


}
