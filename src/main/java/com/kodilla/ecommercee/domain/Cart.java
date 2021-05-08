package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "Carts")
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long cartId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "productsInCarts",
            joinColumns = {@JoinColumn(name = "cartId", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "productId", referencedColumnName = "id")}
    )
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Order order;
}
