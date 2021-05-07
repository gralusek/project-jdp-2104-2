package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue
    private Long cartId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_in_carts",
            joinColumns = {@JoinColumn(name = "cartId", referencedColumnName = "cartId")},
                inverseJoinColumns = {@JoinColumn(name = "productId", referencedColumnName = "productId")}
    )
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Order order;
}
