package com.kodilla.ecommercee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "groups")
public class Groups {
    @Id
    @GeneratedValue
    @NonNull
    private Long groupsId;

    @NonNull
    @Column(name = "name")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "products",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();
}
