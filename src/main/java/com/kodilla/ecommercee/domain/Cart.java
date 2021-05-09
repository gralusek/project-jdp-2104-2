package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Carts")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "productsInCart")
    private List<Product> products;
  
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Order order;
}