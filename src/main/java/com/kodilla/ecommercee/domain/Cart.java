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
@Entity(name = "Carts")
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long cartId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "productsInCarts",
            joinColumns = {@JoinColumn(name = "cartId", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "productId", referencedColumnName = "id")}
    )
    private List<Product> products = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Order order;

    public Cart() {
        this.products = new ArrayList<>();
    }
}
