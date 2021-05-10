package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity(name = "Carts")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long cartId;

    @ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "carts")
    private List<Product> products;
  
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Order order;

    public Cart() {
        this.products = new ArrayList<>();
    }
}
