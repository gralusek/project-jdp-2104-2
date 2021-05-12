package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "`Groups`")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long groupId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products;

    public Group(String name){
        this.name = name;
        products = new ArrayList<>();
    }

}
